package org.papaja.adminfly.commons.mvc.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static java.lang.String.format;
import static java.util.Objects.*;

@Component
public class Modules {

    private HttpServletRequest request;

    @Autowired
    public Modules(HttpServletRequest request) {
        this.request = request;
    }

    public static void register(Module module) {
        Holder.INSTANCE.addModule(module);
    }

    public Collection<Module> getModules() {
        return Holder.INSTANCE.getModules();
    }

    public Module getCurrentModule() {
        Map<String, Module> modules = Holder.INSTANCE.modules;
        String              path    = request.getServletPath();

        if (path.length() > 0) {
            path = path.substring(1);

            if (path.indexOf('/') > 0) {
                path = path.substring(0, path.indexOf('/'));
                path = format("/%s/", path);
            }
        }

        return modules.get(modules.containsKey(path) ? path : null);
    }

    public enum Holder {

        INSTANCE;

        private Map<String, Module> modules;

        Holder() {
            modules = new HashMap<>();
        }

        public void addModule(Module module) {
            modules.put(module.getPath(), module);
        }

        public Collection<Module> getModules() {
            return modules.values();
        }

    }

    public static class Module {

        private Menu.Item link;
        private Menu      menu;

        public Module(String name, String path, Menu menu) {
            this(new Menu.Item(name, path), menu);
        }

        public Module(Menu.Item link, Menu menu) {
            this.link = link;
            this.menu = menu;
        }

        public String getName() {
            return link.getLabel();
        }

        public String getPath() {
            return link.getPath();
        }

        public Menu getMenu() {
            return menu;
        }

        public void setMenu(Menu menu) {
            this.menu = menu;
        }

        @Override
        public int hashCode() {
            return hash(getName(), getPath());
        }

    }

}
