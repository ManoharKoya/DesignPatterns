package org.example.limit.order.book;

import java.time.LocalDateTime;

public class Main {

    public static void main(String args[]) {
        // Background: Stock market orders
        // Order Book
            // Keeps track of buy & sell order which are not completed at instance
            // buy & sell orders will get added to the book,
            // when there is not enough volume & price (of opposite side) to match the order
            // If only some volume is available at that price, transaction will be done for that volume
            // leaving the remaining volume in the order book
        // Once the minPrice of Sell orders is <= maxPrice of Buy orders -> need to make a transaction
        // if both the orders have same price, earlier order should go first


        // base methods
            // placeOrder(Order)
            // getVolumeByPrice(price)
            // cancelOrder(OrderId)
            // checkPossibleTransactions()

        // classes
            // Order
                // orderId
                // price
                // volume
                // timestamp
                // OrderType
            // OrderBook
                // It is better to use Heap / Priority Queue to maintain Buys, Sells
                // Insertion - O(logN), get top - O(1)
                // PriorityQueue<Order, decreasing> Buys; PriorityQueue<Order> Sells;
        // What if we want to get the earlier order
            // can do custom comparator function
            // but, it's better to use Queue inside priority queue (earlier one first)
        // What if we want to cancel the order
            // O(Q) where Q is the items in the Queue of price P
            // option-1: better way is to use the linked list instead of Queue
            // and maintain the HashMap<oderId, *Node> to go to the Node & del the node
            // option-2: to lazyly delete the order by maintaining the HashSet<orderId> for calcellation
            // and remove/don't consider the Order when came across

        // discuss the downsides of both the approaches

        OrderBook orderBook = new OrderBook();
        Order buyOrder1 = new Order(
                2.54,
                3.0,
                "JISFBDI",
                LocalDateTime.now(),
                new Client("ODIAFNB", "client-1"),
                OrderType.BUY
        );
        Order sellOrder1 = new Order(
                2.55,
                3.0,
                "JDSHFB",
                LocalDateTime.now(),
                new Client("ASIDHF", "client-2"),
                OrderType.SELL
        );
        Order buyOrder2 = new Order(
                2.56,
                2.0,
                "EKHGBO",
                LocalDateTime.now(),
                new Client("AEVBK", "client-3"),
                OrderType.BUY
        );
        orderBook.placeOrder(buyOrder1);
        orderBook.placeOrder(sellOrder1);
        orderBook.placeOrder(buyOrder2);
    }


}
