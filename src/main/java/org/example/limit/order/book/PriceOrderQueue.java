package org.example.limit.order.book;

import org.example.limit.order.book.linked.list.LinkedList;
import org.example.limit.order.book.linked.list.Node;

import java.util.HashMap;

public class PriceOrderQueue {
    double price;
    double totalVolume;
    LinkedList<Order> orderQueue;
    HashMap<String, Node<Order>> orderAddressMap;

    PriceOrderQueue() {
        this.orderQueue = new LinkedList<>();
        this.totalVolume = 0; this.price = 0;
        this.orderAddressMap = new HashMap<>();
    }

    public void insert(Order order) {
        if(this.price != order.price) this.price = order.price;
        this.totalVolume += order.volume;
        Node<Order> node = this.orderQueue.insertNode(order);
        this.orderAddressMap.put(order.id, node);
    }

    public void removeOrder(Node<Order> node) {
        this.totalVolume -= node.data.volume;
        orderQueue.deleteNode(node);
    }
}
