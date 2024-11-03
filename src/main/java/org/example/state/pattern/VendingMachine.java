package org.example.state.pattern;

public class VendingMachine implements State{

    int numberOfAisles;

    int requestAisleNumber;
    double coins;
    State coinInsertState, disbursementState, pressButtonState, currentState;

    public VendingMachine(int numberOfAisles) {
        this.numberOfAisles = numberOfAisles;
        coinInsertState = new CoinInsertedState(this);
        disbursementState = new DisburseItemState(this);
        pressButtonState = new PressButtonState(this);
        currentState = coinInsertState;
    }



    public int getNumberAisles() {
        return this.numberOfAisles;
    }

    public void setRequestAisleNumber(int requestAisleNumber) {
        this.requestAisleNumber = requestAisleNumber;
    }

    @Override
    public void insertCoin(double coins) throws Exception {
        this.currentState.insertCoin(coins);
    }

    @Override
    public void pressButton(int aisleNumber) throws Exception {
        this.currentState.pressButton(aisleNumber);
    }

    @Override
    public void disburseItem(int aisleNumber) throws Exception {
        this.currentState.disburseItem(aisleNumber);
    }

    public boolean isItemAvailable(int aisleNumber) {
        return true;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public void setState(StateEnum disburseItem) {
        switch (disburseItem) {
            case INSERT_COIN -> this.currentState = coinInsertState;
            case PRESS_BUTTON -> this.currentState = pressButtonState;
            case DISBURSE_ITEM -> this.currentState = disbursementState;
        }
    }

    public void getItem(int aisleNumber) {
        System.out.printf("Getting item from aisle: %d", aisleNumber);
    }
}
