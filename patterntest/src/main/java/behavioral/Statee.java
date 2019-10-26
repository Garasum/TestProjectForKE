package behavioral;

/**
 * class behavior changes based on its state.
 */
public class Statee {
    //Create an interface.
    public interface State {
        public void doAction(Context context);
    }

    //Create concrete classes implementing the same interface.
    public class StartState implements State {

        public void doAction(Context context) {
            System.out.println("Player is in start state");
            context.setState(this);
        }

        public String toString() {
            return "Start State";
        }
    }

    public class StopState implements State {

        public void doAction(Context context) {
            System.out.println("Player is in stop state");
            context.setState(this);
        }

        public String toString() {
            return "Stop State";
        }
    }

    //Create Context Class.
    public class Context {
        private State state;

        public Context() {
            state = null;
        }

        public void setState(State state) {
            this.state = state;
        }

        public State getState() {
            return state;
        }
    }

    public static void main(String[] args) {
        Statee s = new Statee();

        Context context = s.new Context();

        StartState startState = s.new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = s.new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
