package org.example.limit.order.book.linked.list;

public class LinkedList<E> {
    public Node<E> head;
    public Node<E> tail;

    public LinkedList(E data) {
        Node<E> headNode = new Node(data);
        this.head = headNode;
        this.tail = headNode;
    }

    public LinkedList() {
        this.head = null;
    }

    public Node<E> insertNode(E data) {
        Node<E> node = new Node(data);
        if(this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
        return node;
    }

    public void deleteNode(Node<E> node) {
        if(node == null) return;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if(prev != null) prev.next = next;
        if(next != null) next.prev = prev;
    }
}
