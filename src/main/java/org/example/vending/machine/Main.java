package org.example.vending.machine;

public class Main {
    // vending machine
    // requirements clarification:
        // number of rows
        // each row have fixed number of slots
        // all slots same capacity
        // each slot have same type of item & each slot can have x number of items x <= capacity

        // is this a basic display unit to just show the price?
        // or would this be a robust display where I can show the item details & inventory details?

        // should be able to
            // add an item to the slot
            // remove/buy an item from the slot
            // every Item should have unique price
            // display the price of an item

        // users should not be able to buy if there are no items available in the slot

        // payment services
            // cash | credit card

        // payment transaction & item disbursement should be atomic - 2 phase commit
            // 1. Task-A is done (transaction)
            // 2. Task-B is failed (item disbursement)
            // 3. Should revert Task-A (refund the transaction)


    // Selected Subset of feature
    // lets try to implement the core vending machine
    // lets ignore the payment processing details
    // adding, removing/buys items, display the price
    // abstract payment service
    // 2-phase commit on high level

    public static void main(String args[]) {

    }

    // SOLUTION:
        // USE State Pattern > see state.pattern

}
