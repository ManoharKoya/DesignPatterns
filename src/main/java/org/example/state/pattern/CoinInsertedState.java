package org.example.state.pattern;

import org.example.state.pattern.VendingMachine;

public class CoinInsertedState implements State{

    private VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double coins) {
        vendingMachine.setCoins(coins);
        vendingMachine.setState(StateEnum.PRESS_BUTTON);
    }

    @Override
    public void pressButton(int aisleNumber) throws Exception {
        throw new Exception("Invalid operation at this step");
    }

    @Override
    public void disburseItem(int aisleNumber) throws Exception {
        throw new Exception("Invalid operation at this step");
    }
}
