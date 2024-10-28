package org.example.limit.order.book;

import org.example.limit.order.book.linked.list.Node;

import java.util.*;

public class OrderBook {

    TreeMap<Double, PriceOrderQueue> buys;
    TreeMap<Double, PriceOrderQueue> sells;

    OrderBook() {
        buys = new TreeMap<>(
                (o1, o2) -> {
                    if (o2 - o1 < 0) {
                        return -1;
                    } else if (o2 - o1 > 0) {
                        return 1;
                    } else return 0;
                }
        );
        sells = new TreeMap<>(
                (o1, o2) -> {
                    if (o1 - o2 < 0) {
                        return -1;
                    } else if (o1 - o2 > 0) {
                        return 1;
                    } else return 0;
                }
        );
    }

    public void cancelOrder(Order order) {
        TreeMap<Double, PriceOrderQueue> orders;
        if (order.type == OrderType.SELL) orders = sells;
        else orders = buys;
        PriceOrderQueue orderQueue = orders.get(order.price);
        Node<Order> cancelOrderNode = orderQueue.orderAddressMap.get(order.id);
        orderQueue.removeOrder(cancelOrderNode);
    }

    public void placeOrder(Order order) {
        TreeMap<Double, PriceOrderQueue> orders;
        if (order.type == OrderType.SELL) orders = sells;
        else orders = buys;
        if (orders.get(order.price) != null) {
            // already present orderQueue for price
            System.out.printf("Inserting order: %s to existing order queue\n", order.id);
            PriceOrderQueue orderQueue = orders.get(order.price);
            orderQueue.insert(order);
        } else {
            // create new order queue and insert in TreeMap
            System.out.printf("Creating new order queue for order: %s\n", order.id);
            PriceOrderQueue newOrderQueue = new PriceOrderQueue();
            System.out.printf("Inserting order: %s to existing order queue\n", order.id);
            newOrderQueue.insert(order);
            orders.put(order.price, newOrderQueue);
        }
        checkPossibleTransactions();
    }

    public void checkPossibleTransactions() {
        PriceOrderQueue topBuyOrders = getTop(OrderType.BUY);
        PriceOrderQueue topSellOrders = getTop(OrderType.SELL);
        if (topSellOrders == null || topBuyOrders == null) return;
        if (topSellOrders.price <= topBuyOrders.price) {
            // possible
            Node<Order> sellNode = topSellOrders.orderQueue.head;
            Node<Order> buyNode = topBuyOrders.orderQueue.head;
            while (sellNode != null && buyNode != null) { // 2-pointer approach
                double transactionVolume;
                Node<Order> nextSellNode = sellNode, nextBuyNode = buyNode;
                System.out.printf(
                        "Transaction between SellOrder: %s & BuyOrder: %s\n",
                        sellNode.data.id,
                        buyNode.data.id);
                if (sellNode.data.volume >= buyNode.data.volume) {
                    transactionVolume = buyNode.data.volume;
                    sellNode.data.volume -= transactionVolume;
                    topSellOrders.totalVolume -= transactionVolume;
                    topBuyOrders.totalVolume -= transactionVolume;
                    buyNode.data.volume = 0;
                } else {
                    transactionVolume = sellNode.data.volume;
                    buyNode.data.volume -= transactionVolume;
                    topSellOrders.totalVolume -= transactionVolume;
                    topBuyOrders.totalVolume -= transactionVolume;
                    sellNode.data.volume = 0;
                }
                if (sellNode.data.volume == 0) {
                    nextSellNode = sellNode.next;
                    topSellOrders.removeOrder(sellNode); // removing order as no volume left
                }
                if (buyNode.data.volume == 0) {
                    nextBuyNode = buyNode.next;
                    topBuyOrders.removeOrder(buyNode); // removing order as no volume left
                }
                sellNode = nextSellNode;
                buyNode = nextBuyNode;
            }
        }
    }

    // get the total volume,
    // least priced volume if type=sells,
    // most priced volume if type=buys
    private PriceOrderQueue getTop(OrderType orderType) {
        TreeMap<Double, PriceOrderQueue> orders;
        if (orderType == OrderType.SELL) orders = sells;
        else orders = buys;
        if (orders.firstEntry() == null) return null;
        return orders.firstEntry().getValue();
    }
}
