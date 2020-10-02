package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
   
private HashMap<String, Item> itemCollection;
    TheSystem() {
        itemCollection = new HashMap<String, Item>();
        if (getClass().getSimpleName().equals("AppSystem")) {
            try {
                Scanner sc = new Scanner(new File("resources/sample.txt"));
                while (sc.hasNextLine()) {
                    Item item = new Item();
                    String line = sc.nextLine();
                    String[] itemInfo = line.split("\\s{2,}");
                    item.setItemName(itemInfo[0]);
                    item.setItemDesc(itemInfo[1]);
                    item.setItemPrice(Double.parseDouble(itemInfo[2]));
                    item.setAvailableQuantity(Integer.parseInt(itemInfo[3]));
                    itemCollection.put(item.getItemName(), item);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    public HashMap<String, Item> getItemCollection(){
        return itemCollection;
    }
    
    public Boolean checkAvailability(Item item) {
        if (item == null || item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.println("System is unable to add " + item.getItemName() + " to the cart. System only has " +
                    item.getAvailableQuantity() + item.getItemName() + "s.");
            return false;
        }
        return true;
    }
    
    public Boolean add(Item item) {
        if (item == null) {
            return false;
        }
        if (itemCollection.containsKey(item.getItemName())) {
            item.setQuantity(item.getQuantity() + 1);
            return true;
        } else {
            itemCollection.put(item.getItemName(), item);
            return true;
        }
    }

    public Item remove(String itemName) {
        if (!itemCollection.containsKey(itemName)) {
            return null;
        } else {
            return itemCollection.remove(itemName);
        }
    }

    public void setItemCollection(HashMap<String, Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public abstract void display();
}
