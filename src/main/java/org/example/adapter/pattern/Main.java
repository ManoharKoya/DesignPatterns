package org.example.adapter.pattern;

public class Main {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();

        // we have ADAPTED out Turkey as a Duck
        Duck duck = new TurkeyAdapter(turkey);
        // and passed it to a third party method which can only work with Duck
        workWithDuck(duck);
    }

    private static void workWithDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
