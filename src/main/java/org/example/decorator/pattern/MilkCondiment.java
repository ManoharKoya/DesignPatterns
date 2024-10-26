package org.example.decorator.pattern;

public class MilkCondiment extends CondimentsDecorator{
    MilkCondiment(Beverage baseBeverage) {
        this.baseBeverage = baseBeverage;
    }
    public double cost() {
        return baseBeverage.cost() + 0.29;
    }
}
