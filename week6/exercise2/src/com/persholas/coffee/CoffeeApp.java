package com.persholas.coffee;

import java.util.Scanner;

public class CoffeeApp {
    public static void main(String[] args) {
        Product coffee = new Product();
        coffee.setName("coffee");
        coffee.setPrice(2);
        coffee.setDescription("it is good coffee with milk");

        Product tea = new Product("tea", 1.5, "hot tea");

        Scanner input = new Scanner(System.in);
        System.out.println("welcome to our coffee shop");
        System.out.println("How many coffee you like?");
    }
}
