package org.example.decorator.pattern;

public class Main {
    public static void main(String args[]) {
        // Need a DarkRoast with double Milk & a Whip-cream
        Beverage darkRoastBeverage = new DarkRoast();
        darkRoastBeverage = new MilkCondiment(darkRoastBeverage);
        darkRoastBeverage = new MilkCondiment(darkRoastBeverage);
        darkRoastBeverage = new WhipCondiment(darkRoastBeverage);
        double darkRoastCost = darkRoastBeverage.cost();
        System.out.printf("Cost of Double Milk, Whip - DarkRoast coffee is %f\n", darkRoastCost);

        // Need a LightRoast with Milk & a Whip-cream
        Beverage lightRoastBeverage = new WhipCondiment(
                                        new MilkCondiment(
                                            new LightRoast()
                                        )
                                    );
        double lightRoastCost = lightRoastBeverage.cost();
        System.out.printf("Cost of Light roast Milk, Whip coffee is %f\n", lightRoastCost);
    }

}
