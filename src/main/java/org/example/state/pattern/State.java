package org.example.state.pattern;

public interface State {
    public abstract void insertCoin(double coins) throws Exception;
    public abstract void pressButton(int aisleNumber) throws Exception;
    public abstract void disburseItem(int aisleNumber) throws Exception;
}
