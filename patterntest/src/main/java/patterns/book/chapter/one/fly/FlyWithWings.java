package patterns.book.chapter.one.fly;

import patterns.book.chapter.one.interfaces.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
