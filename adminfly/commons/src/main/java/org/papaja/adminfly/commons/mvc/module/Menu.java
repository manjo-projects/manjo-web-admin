package org.papaja.adminfly.commons.mvc.module;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Menu {

    private List<Item>     items;

    public Menu() {
        this.items = new ArrayList<>();
    }

    public void setItems(Item... items) {
        this.items.addAll(asList(items));
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItem(String label, String path) {
        addItem(new Item(label, path));
    }

    public static class Item {

        private String label;
        private String path;

        public Item(String label, String path) {
            this.label = label;
            this.path = path;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }

}
