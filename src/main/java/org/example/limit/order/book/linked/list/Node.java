package org.example.limit.order.book.linked.list;

import org.example.limit.order.book.Order;

public class Node<E> {
    public E data;
    public Node<E> next, prev;

    Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
