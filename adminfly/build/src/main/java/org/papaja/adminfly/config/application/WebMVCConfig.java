package org.papaja.adminfly.config.application;

import org.hibernate.validator.HibernateValidator;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.spring.JtwigView;
import org.jtwig.spring.asset.SpringAssetExtension;
import org.jtwig.spring.asset.resolver.AssetResolver;
import org.jtwig.translate.spring.SpringTranslateExtension;
import org.jtwig.translate.spring.SpringTranslateExtensionConfiguration;
import org.jtwig.web.servlet.JtwigRenderer;
import org.papaja.adminfly.commons.DataHolder;
import org.papaja.adminfly.commons.vendor.jtwig.extension.asset.resolver.ResourceUrlBasedAssetResolver;
import org.papaja.adminfly.commons.vendor.jtwig.extension.theme.ThemeResolverExtension;
import org.papaja.adminfly.commons.vendor.jtwig.extension.url.UrlPathExtension;
import org.papaja.adminfly.commons.vendor.jtwig.spring.MultipleTemplateViewResolver;
import org.papaja.adminfly.commons.vendor.spring.web.servlet.handler.ModuleChangerInterceptor;
import org.papaja.adminfly.commons.vendor.spring.web.servlet.resource.ContentHashVersionStrategy;
import org.papaja.function.Supplier;
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
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.beanutils.PropertyUtils.getProperty;
import static org.papaja.util.StringUtils.substringBetween;

@SuppressWarnings({"unused"})
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource("classpath:properties/application.properties")
@ComponentScan(
        basePackages = {
                "org.papaja.adminfly.config",
                "org.papaja.adminfly.commons",
                "org.papaja.adminfly.module",
        }
)
public class WebMVCConfig implements WebMvcConfigurer {

    private static final Charset     UTF8   = StandardCharsets.UTF_8;
    private static final Logger      LOGGER = Logger.getLogger(WebMVCConfig.class.getName());
    protected            Environment environment;

    private int counter = 0;

    @Autowired
    public WebMVCConfig(Environment environment) {
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
        MultipleTemplateViewResolver resolver = new MultipleTemplateViewResolver("module/");

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
        resolver.setCookieMaxAge(valueOf(requireNonNull(environment.getProperty("app.view.theme.cookieMaxAge"))));
        resolver.setDefaultThemeName(requireNonNull(environment.getProperty("app.view.theme.default")));

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

        for (String pattern : new String[]{
                "classpath*:locale/module/**/*.properties",
                "classpath*:locale/shared/**/*.properties"
        }) {
            try {
                Resource[] resources = resolver.getResources(pattern);

                for (Resource resource : resources) {
                    source.addBasenames(
                            format("classpath:%s", substringBetween("locale", "_", resource.getURI().toString()))
                    );
                }
            } catch (IOException ignore) {
            }
        }

        return source;
    }

    @Bean
    public DataHolder modulesDataHolder() {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Yaml                    yaml     = new Yaml();
        DataHolder              source   = DataHolder.HOLDER;
        String[]                required = {"main.key", "main.name",};

        try {
            String     pattern         = "classpath*:**/module.yaml";
            Resource[] resources       = resolver.getResources(pattern);

            boolean    isValidResource;

            for (Resource resource : resources) {
                Map<String, Object> data = yaml.load(resource.getInputStream());
                isValidResource = true;

                for (String path : required) {
                    try {
                        if (isNull(getProperty(data, path))) {
                            isValidResource = false;
                            break;
                        }
                    } catch (Exception skip) {
                        isValidResource = false;
                        break;
                    }
                }

                if (isValidResource) {
                    source.put((String) getProperty(data, "main.key"), data);
                }
            }

        } catch (Throwable ignore) {
            // ignore all exception
            LOGGER.warning(ignore.getMessage());
        }

        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();

        resolver.setCookieName(environment.getProperty("app.locale.cookieName"));
        resolver.setCookieMaxAge(valueOf(requireNonNull(environment.getProperty("app.locale.cookieMaxAge"))));

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
        registry.addInterceptor(moduleContextChangeInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("static/**")
                .addResourceLocations("classpath:/assets/", "/assets/")
                .setCachePeriod(2629743)
                .resourceChain(true)
                .addResolver(new EncodedResourceResolver())
                .addResolver(new VersionResourceResolver()
                        .addVersionStrategy(new ContentHashVersionStrategy(), "/**"));
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

        interceptor.setParamName(requireNonNull(environment.getProperty("app.locale.queryParameterName")));

        return interceptor;
    }

    @Bean
    public ThemeChangeInterceptor themeChangeInterceptor() {
        ThemeChangeInterceptor interceptor = new ThemeChangeInterceptor();

        interceptor.setParamName(requireNonNull(environment.getProperty("app.view.theme.queryParameterName")));

        return interceptor;
    }

    @Bean
    public ModuleChangerInterceptor moduleContextChangeInterceptor() {
        return new ModuleChangerInterceptor();
    }


    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();

        multipartResolver.setMaxUploadSize(parseInt(requireNonNull(environment.getProperty("app.file.upload.maxSize"))));

        return multipartResolver;
    }

}