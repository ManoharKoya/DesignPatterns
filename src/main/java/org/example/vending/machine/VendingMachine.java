package org.example.vending.machine;

import java.util.*;

public class VendingMachine {
    // pop items
    List<List<Integer>> slotItemCount;
    List<List<Item>> slotItemDetails;
    int slotCapacity;
    int numberOfRows, numberOfSlots;

    public VendingMachine(int slotCapacity, int numberOfRows, int numberOfSlots) {
        this.slotCapacity = slotCapacity;
        this.numberOfRows = numberOfRows;
        this.numberOfSlots = numberOfSlots;
        slotItemCount = new ArrayList<>(numberOfRows);
        for(int i=0; i<numberOfRows; i++) slotItemCount.set(i, new ArrayList<>(numberOfSlots));
        slotItemDetails = new ArrayList<>(numberOfRows);
        for(int i=0; i<numberOfRows; i++) slotItemDetails.set(i, new ArrayList<>(numberOfSlots));
    }

    public void addItem(Item item, int row, int column, int numberOfItems) throws Exception {
        // if there is something in it
            // if it already has some other thing
                // throw an exception
        // if count of existing + numberOfItems > capacity
            // throw an exception
        int existingItemCount = slotItemCount.get(row).get(column);
        Item existingItem = slotItemDetails.get(row).get(column);
        if(existingItemCount>0 && existingItem != item) {
            throw new Exception("Item mismatch error: trying to add different kind of item in the slot.");
        }
        if(existingItemCount+numberOfItems > slotCapacity) {
            throw new Exception("Item overfill error: trying to add excess number of items than capacity");
        }
        // add items
        slotItemCount.get(row).set(column, existingItemCount + numberOfItems);
        slotItemDetails.get(row).set(column, item);
    }

    public int getItemCount(int row, int column) {
        return slotItemCount.get(row).get(column);
    }

    public Item getItem(int row, int column) throws Exception {
        Item item = slotItemDetails.get(row).get(column);
        if(item == null) throw new Exception("Item dosen't exist: No item found in the Slot");
        return item;
    }

    public void buyItem(int row, int column, PaymentMethod paymentMethod) throws Exception {
        double price = getItem(row, column).getPrice();
        // ProcessPayment
        // removeItem
    }

}
