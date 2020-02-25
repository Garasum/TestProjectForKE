package patterns.book.chapter.one.ducks;

import patterns.book.chapter.one.fly.FlyWithWings;
import patterns.book.chapter.one.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm real Mallard duck");
    }
}
