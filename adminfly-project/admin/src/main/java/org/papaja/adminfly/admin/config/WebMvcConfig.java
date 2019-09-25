package org.papaja.adminfly.admin.config;

import org.hibernate.validator.HibernateValidator;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.spring.JtwigView;
import org.jtwig.spring.asset.SpringAssetExtension;
import org.jtwig.spring.asset.resolver.AssetResolver;
import org.jtwig.translate.spring.SpringTranslateExtension;
import org.jtwig.translate.spring.SpringTranslateExtensionConfiguration;
import org.jtwig.web.servlet.JtwigRenderer;
import org.papaja.commons.function.Supplier;
import org.papaja.adminfly.core.vendor.jtwig.extension.url.UrlPathExtension;
import org.papaja.adminfly.core.vendor.jtwig.extension.asset.resolver.ResourceUrlBasedAssetResolver;
import org.papaja.adminfly.core.vendor.jtwig.extension.theme.ThemeResolverExtension;
import org.papaja.adminfly.core.vendor.jtwig.spring.MultipleTemplateViewResolver;
import org.papaja.adminfly.core.vendor.spring.web.servlet.resource.ContentHashVersionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.ui.context.ThemeSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

import static java.lang.String.format;
import static org.papaja.commons.util.StringUtils.substringBetween;

@SuppressWarnings({"unused"})
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource("classpath:properties/application.properties")
@ComponentScan(
        basePackages = {
                "org.papaja.adminfly.admin.controller",
                "org.papaja.adminfly.module.*.controller"
        }
)
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    protected Environment environment;

    @Autowired
    private ServletContext context;

    @Autowired
    public WebMvcConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public ViewResolver viewResolver() {
        Supplier<JtwigRenderer> supplier = () -> {
            EnvironmentConfigurationBuilder builder = EnvironmentConfigurationBuilder.configuration();

            builder.extensions()
                    .add(new SpringAssetExtension())
                    .add(new ThemeResolverExtension())
                    .add(new UrlPathExtension())
                    .add(new SpringTranslateExtension(
                            SpringTranslateExtensionConfiguration.builder(messageSource())
                                    .withLocaleResolver(localeResolver()).build()
                    ));

            builder.render().withOutputCharset(UTF8);
            builder.resources().withDefaultInputCharset(UTF8);

            return new JtwigRenderer(builder.build());
        };
        MultipleTemplateViewResolver resolver = new MultipleTemplateViewResolver("admin/", "module/", "admin/");

        resolver.setRenderer(supplier.get());
        resolver.setViewClass(JtwigView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".twig");
        resolver.setContentType("text/html");

        return resolver;
    }

    @Bean
    public ThemeSource themeSource() {
        ResourceBundleThemeSource source = new ResourceBundleThemeSource();

        source.setBasenamePrefix("theme/");
        source.setFallbackToSystemLocale(true);
        source.setDefaultEncoding("UTF-8");

        return source;
    }

    @Bean
    public ThemeResolver themeResolver() {
        CookieThemeResolver resolver = new CookieThemeResolver();

        resolver.setCookieMaxAge(2400);
        resolver.setCookieName(environment.getProperty("app.view.theme.cookieName"));
        resolver.setCookieMaxAge(Integer.valueOf(environment.getProperty("app.view.theme.cookieMaxAge")));
        resolver.setDefaultThemeName(environment.getProperty("app.view.theme.default"));

        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source   = new ReloadableResourceBundleMessageSource();
        ResourcePatternResolver               resolver = new PathMatchingResourcePatternResolver();

        source.setResourceLoader(new PathMatchingResourcePatternResolver());
        source.addBasenames(
                "classpath:locale/common/validation/validation",
                "classpath:locale/common/text/text",
                "classpath:locale/common/title/title",
                "classpath:locale/common/label/label",
                "classpath:locale/common/flash/flash"
        );
        source.setFallbackToSystemLocale(true);
        source.setDefaultEncoding("UTF-8");

        try {
            String     pattern   = "classpath:locale/module/**/*.properties";
            Resource[] resources = resolver.getResources(pattern);

            for (Resource resource : resources) {
                System.out.println(resource.toString());
                source.addBasenames(
                    format("classpath:%s", substringBetween("locale", "_", resource.getURI().toString()))
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();

        if (false) {
            resolver.setDefaultLocale(Locale.forLanguageTag(environment.getProperty("app.locale.default").replace('_', '-')));
        }

        resolver.setCookieName(environment.getProperty("app.locale.cookieName"));
        resolver.setCookieMaxAge(Integer.valueOf(environment.getProperty("app.locale.cookieMaxAge")));

        return resolver;
    }

    @Bean
    public AssetResolver assetResolver() {
        ResourceUrlBasedAssetResolver resolver = new ResourceUrlBasedAssetResolver();

        resolver.setPrefix("/static");

        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(themeChangeInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("static/**")
                .addResourceLocations("classpath:/assets/")
                .setCachePeriod(2629743)
                .resourceChain(true)
                .addResolver(new EncodedResourceResolver())
                .addResolver(new VersionResourceResolver()
                        .addVersionStrategy(new ContentHashVersionStrategy(), "/**/*.css", "/**/*.js"));
    }

    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }

    @Bean
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

        validator.setValidationMessageSource(messageSource());
        validator.setProviderClass(HibernateValidator.class);

        return validator;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();

        interceptor.setParamName(environment.getProperty("app.locale.queryParameterName"));

        return interceptor;
    }

    @Bean
    public ThemeChangeInterceptor themeChangeInterceptor() {
        ThemeChangeInterceptor interceptor = new ThemeChangeInterceptor();

        interceptor.setParamName(environment.getProperty("app.view.theme.queryParameterName"));

        return interceptor;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();

        multipartResolver.setMaxUploadSize(Integer.valueOf(environment.getProperty("app.file.upload.maxSize")));

        return multipartResolver;
    }


}