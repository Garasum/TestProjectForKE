package behavioral;

/**
 * a class behavior or its algorithm can be changed at run time.
 */
public class Strategyy {
    //Create an interface.
    public interface Strategy {
        public int doOperation(int num1, int num2);
    }

    //Create concrete classes implementing the same interface.
    public class OperationAdd implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 + num2;
        }
    }

    public class OperationSubstract implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 - num2;
        }
    }

    public class OperationMultiply implements Strategy {
        @Override
        public int doOperation(int num1, int num2) {
            return num1 * num2;
        }
    }

    //Create Context Class.
    public class Context {
        private Strategy strategy;

        public Context(Strategy strategy){
            this.strategy = strategy;
        }

        public int executeStrategy(int num1, int num2){
            return strategy.doOperation(num1, num2);
        }
    }

    public static void main(String[] args) {
        Strategyy s = new Strategyy();

        Context context = s.new Context(s.new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = s.new Context(s.new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = s.new Context(s.new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
