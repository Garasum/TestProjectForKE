package behavioral;

/**
 * an abstract class exposes defined way(s)/template(s) to execute its methods.
 * Its subclasses can override the method implementation as per need but the invocation is to be in the same way as defined by an abstract class.
 */
public class Template {
    //Create an abstract class with a template method being final.
    public abstract class Game {
        abstract void initialize();

        abstract void startPlay();

        abstract void endPlay();

        //template method
        public final void play() {

            //initialize the game
            initialize();

            //start game
            startPlay();

            //end game
            endPlay();
        }
    }

    //Create concrete classes extending the above class.
    public class Cricket extends Game {
        @Override
        void endPlay() {
            System.out.println("Cricket Game Finished!");
        }

        @Override
        void initialize() {
            System.out.println("Cricket Game Initialized! Start playing.");
        }

        @Override
        void startPlay() {
            System.out.println("Cricket Game Started. Enjoy the game!");
        }
    }

    public class Football extends Game {

        @Override
        void endPlay() {
            System.out.println("Football Game Finished!");
        }

        @Override
        void initialize() {
            System.out.println("Football Game Initialized! Start playing.");
        }

        @Override
        void startPlay() {
            System.out.println("Football Game Started. Enjoy the game!");
        }
    }

    //Use the Game's template method play() to demonstrate a defined way of playing game.
    public static void main(String[] args) {
        Template t = new Template();

        Game game = t.new Cricket();
        game.play();

        System.out.println();

        game = t.new Football();
        game.play();
    }

}
