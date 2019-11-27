package org.papaja.adminfly.module.admin.config;

import org.papaja.adminfly.commons.mvc.module.Menu;
import org.papaja.adminfly.commons.mvc.module.Modules;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    public AdminConfig() {
        Menu menu = new Menu();

        menu.addItem(new Menu.Item("title.authority", "/authority"));
        menu.addItem(new Menu.Item("title.users", "/users"));
        menu.addItem(new Menu.Item("title.application", "/application"));

        Modules.register(new Modules.Module("Admin", null, menu));
    }

}
