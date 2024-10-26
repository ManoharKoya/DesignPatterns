package org.example.decorator.pattern;

public class WhipCondiment extends CondimentsDecorator{
    WhipCondiment(Beverage baseBeverage) {
        this.baseBeverage = baseBeverage;
    }
    public double cost() {
        return this.baseBeverage.cost() + 0.59;
    }
}
