package org.example.vending.machine;

public class Item {
    public String id;
    public String name;
    public String description;
    public double price;

    public Item(String id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
