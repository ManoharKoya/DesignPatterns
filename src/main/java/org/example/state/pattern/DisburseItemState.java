package org.example.state.pattern;

public class DisburseItemState implements State{

    private VendingMachine vendingMachine;

    public DisburseItemState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double coins) throws Exception {
        throw new Exception("Invalid operation at this step");
    }

    @Override
    public void pressButton(int aisleNumber) throws Exception {
        throw new Exception("Invalid operation at this step");
    }

    @Override
    public void disburseItem(int aisleNumber) throws Exception {
        if(vendingMachine.isItemAvailable(aisleNumber)) {
            vendingMachine.disburseItem(aisleNumber);
        } else {
            throw new Exception("Item unavailable: can not disburse item");
        }
    }
}
