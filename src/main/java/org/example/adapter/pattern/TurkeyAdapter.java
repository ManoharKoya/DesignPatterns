package org.example.adapter.pattern;

public class TurkeyAdapter implements Duck{

    private Turkey turkey;
    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        // wrap gobble of Turkey as quack of Duck
        this.turkey.gobble();
    }

    public void fly() {
        // wrap fly of Turkey as fly of Duck
        this.turkey.fly();
    }
}
