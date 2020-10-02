package com.example;

import java.text.DecimalFormat;
import java.util.HashMap;

public class CartSystem extends TheSystem {
    CartSystem() {
    }

    @Override
    public void display() {
        HashMap<String, Item> hm = getItemCollection();
        Double sumSubTotal = 0.0;
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println("Cart:");
        System.out.println(String.format("%-20s", "Name") + String.format("%-20s", "Description")
                + String.format("%-10s", "Price") + String.format("%-10s", "Quantity")
                + String.format("%-10s", "Sub Total"));
        for (String name : hm.keySet()) {
            Item it = hm.get(name);
            String item_name_v = it.getItemName();
            item_name_v = String.format("%-20s", item_name_v);
            String item_desc_v = it.getItemDesc();
            item_desc_v = String.format("%-20s", item_desc_v);
            String item_price_v = df.format(it.getItemPrice());
            item_price_v = String.format("%-10s", item_price_v);
            String item_Q_v = it.getQuantity().toString();
            item_Q_v = String.format("%-10s", item_Q_v);
            Double item_subT_v_s = it.getQuantity() * it.getItemPrice();
            String item_subT_v = String.format("%-10s", df.format(item_subT_v_s));
            System.out.println(item_name_v + item_desc_v + item_price_v + item_Q_v + item_subT_v);
            sumSubTotal = sumSubTotal + item_subT_v_s;
        }
        Double tax = sumSubTotal * 0.05;
        Double total = tax + sumSubTotal;

        System.out.print(String.format("%-20s", "Pre-tax Total"));
        System.out.println(String.format("%-20s", df.format(sumSubTotal)));
        System.out.print(String.format("%-20s", "Tax"));
        System.out.println(String.format("%-20s", df.format(tax)));
        System.out.print(String.format("%-20s", "Total"));
        System.out.println(String.format("%-20s", df.format(total)));
    }
}
