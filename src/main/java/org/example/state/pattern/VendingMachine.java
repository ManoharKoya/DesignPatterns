package org.example.state.pattern;

public class VendingMachine {

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

    public void disburseItem(int aisleNumber) {
    }

    public boolean isItemAvailable(int aisleNumber) {
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
}
