package org.papaja.adminfly.config;

import org.papaja.adminfly.commons.ui.UIData;
import org.papaja.adminfly.commons.ui.UIDataKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
public class ExtraConfig {

    @Autowired
    private Environment environment;

    @Bean
    public UIDataKeeper uiDataKeeper() {
        UIData.DEFAULT_UI_DATA.setLabel(environment.getProperty("project.name"));

        return UIDataKeeper.UI_DATA_KEEPER;
    }

}
