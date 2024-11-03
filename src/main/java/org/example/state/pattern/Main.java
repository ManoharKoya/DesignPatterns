package org.example.state.pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        VendingMachine vendingMachine = new VendingMachine(5);
        vendingMachine.insertCoin(2.0);
        vendingMachine.pressButton(3);
        vendingMachine.disburseItem(3);
    }

}
