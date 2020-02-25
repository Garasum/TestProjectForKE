package patterns.book.chapter.one.quack;

import patterns.book.chapter.one.interfaces.QuackBehavior;

public class Squeack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeack");
    }
}
