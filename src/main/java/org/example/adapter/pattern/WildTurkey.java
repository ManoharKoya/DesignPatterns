package org.example.adapter.pattern;

public class WildTurkey implements Turkey{
    public void gobble() {
        for(int i=0; i<5; ++i)
            System.out.println("Quack");
    }
    public void fly() {
        System.out.println("Wild Turkey flying");
    }
}
