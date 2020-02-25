package patterns.book.chapter.one;

import patterns.book.chapter.one.ducks.Duck;
import patterns.book.chapter.one.ducks.MallardDuck;
import patterns.book.chapter.one.ducks.ModelDuck;
import patterns.book.chapter.one.fly.FlyRocketPowered;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        System.out.println();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
