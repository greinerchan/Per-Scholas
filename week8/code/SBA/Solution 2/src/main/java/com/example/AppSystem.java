package com.example;

import java.text.DecimalFormat;
import java.util.HashMap;

public class AppSystem extends TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        HashMap<String, Item> hm = getItemCollection();
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println("AppSystem Inventory:");
        System.out.println(String.format("%-20s", "Name") + String.format("%-20s", "Description")
                + String.format("%-10s", "Price") + String.format("%-10s", "Available Quantity"));
        for (String name : hm.keySet()) {
            Item it = hm.get(name);
            String item_name_v = it.getItemName();
            item_name_v = String.format("%-20s", item_name_v);
            String item_desc_v = it.getItemDesc();
            item_desc_v = String.format("%-20s", item_desc_v);
            String item_price_v = df.format(it.getItemPrice());
            item_price_v = String.format("%-10s", item_price_v);
            String item_AvailQ_v = it.getAvailableQuantity().toString();
            item_AvailQ_v = String.format("%-10s", item_AvailQ_v);
            System.out.println(item_name_v + item_desc_v + item_price_v + item_AvailQ_v);
        }
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        if (item == null) {
            return false;
        }
        if (getItemCollection().containsKey(item.getItemName())) {
            System.out.println(item.getItemName() + " is already in the App System");
            return false;
        } else {
            getItemCollection().put(item.getItemName(), item);
            return true;
        }
    }

    public Item reduceAvailableQuantity(String item_name) {
        if (!getItemCollection().containsKey(item_name)) {
            return null;
        } else {
            Item it = getItemCollection().get(item_name);
            it.setAvailableQuantity(it.getAvailableQuantity() - 1);
            if (it.getAvailableQuantity() == 0) {
                getItemCollection().remove(item_name);
                return null;
            }
            return it;
        }
    }
}
