package org.papaja.adminfly.config.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@SuppressWarnings({"unused"})
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@PropertySource(value = {
    "classpath:properties/database.properties",
    "classpath:properties/database.private.properties"
}, ignoreResourceNotFound = true)
@ComponentScan(
        basePackages = {
                "org.papaja.adminfly.commons.dao"
        },
        basePackageClasses = {
                ApplicationConfiguration.class
        }
)
public class ApplicationConfiguration {

    private Environment environment;

    @Autowired
    public ApplicationConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public HibernateTransactionManager getDefaultTransactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();

        manager.setSessionFactory(getDefaultSessionFactory().getObject());

        return manager;
    }

    @Bean
    public LocalSessionFactoryBean getDefaultSessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();

        factory.setPackagesToScan(
                "org.papaja.adminfly.commons.dao.entity",
                "org.papaja.adminfly.module.**.entity"
        );
        factory.setHibernateProperties(getHibernateProperties());

        return factory;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();

        // Hibernate Settings
        properties.put("hibernate.enable_lazy_load_no_trans", environment.getProperty("hibernate.enableLazyLoadNoTransaction"));
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.showSql"));
        properties.put("hibernate.format_sql", environment.getProperty("hibernate.formatSql"));
        properties.put("hibernate.connection.provider_class", environment.getProperty("hibernate.connection.provider"));
        properties.put("hibernate.connection.autocommit", environment.getProperty("hibernate.connection.autocommit"));

        // Hikari Settings
        properties.put("hibernate.hikari.connectionTimeout", environment.getProperty("hikari.connectionTimeout"));
        properties.put("hibernate.hikari.minimumIdle", environment.getProperty("hikari.minimumIdle"));
        properties.put("hibernate.hikari.maximumPoolSize", environment.getProperty("hikari.maximumPoolSize"));
        properties.put("hibernate.hikari.idleTimeout", environment.getProperty("hikari.idleTimeout"));

        // Data Source Settings
        properties.put("hibernate.connection.driver_class", environment.getProperty("connection.driver"));
        properties.put("hibernate.connection.url", environment.getProperty("connection.url"));
        properties.put("hibernate.connection.username", environment.getProperty("connection.username"));
        properties.put("hibernate.connection.password", environment.getProperty("connection.password"));

        return properties;
    }

}
