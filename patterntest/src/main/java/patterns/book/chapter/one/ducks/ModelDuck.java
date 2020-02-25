package patterns.book.chapter.one.ducks;

import patterns.book.chapter.one.fly.FlyNoWay;
import patterns.book.chapter.one.quack.Quack;

public class ModelDuck extends Duck {
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
