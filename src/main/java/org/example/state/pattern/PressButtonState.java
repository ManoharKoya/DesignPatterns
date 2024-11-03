package org.example.state.pattern;

public class PressButtonState implements State{

    private VendingMachine vendingMachine;

    public PressButtonState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double coins) throws Exception {
        throw new Exception("Invalid operation at this step");
    }

    @Override
    public void pressButton(int aisleNumber) throws Exception {
        if(aisleNumber < 0 || aisleNumber > vendingMachine.getNumberAisles())
            throw new Exception("Invalid Aisle Number");
        vendingMachine.setRequestAisleNumber(aisleNumber);
        vendingMachine.setState(StateEnum.DISBURSE_ITEM);
    }

    @Override
    public void disburseItem(int aisleNumber) throws Exception {
        throw new Exception("Invalid operation at this step");
    }
}
