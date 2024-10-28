package org.example.limit.order.book;

import java.time.LocalDateTime;

public class Order {
    double price;
    double volume;
    String id;
    LocalDateTime postedDateTime;

    // String is enough if all the client names are same
    // Customer
    Client client;
    OrderType type;

    public Order(double price, double volume, String id, LocalDateTime postedDateTime, Client client, OrderType type) {
        this.price = price;
        this.volume = volume;
        this.id = id;
        this.postedDateTime = postedDateTime;
        this.client = client;
        this.type = type;
    }
}
