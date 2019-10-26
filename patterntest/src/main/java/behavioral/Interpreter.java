package behavioral;

/**
 * The best example of interpreter design pattern is java compiler that interprets the java source code into byte code that is understandable by JVM.
 * Google Translator is also an example of interpreter pattern where the input can be in any language and we can get the output interpreted in another language.
 */
public class Interpreter {

    //Our first step will be to write the Interpreter context class that will do the actual interpretation.
    public class InterpreterContext {

        public String getBinaryFormat(int i) {
            return Integer.toBinaryString(i);
        }

        public String getHexadecimalFormat(int i) {
            return Integer.toHexString(i);
        }
    }

    //Now we need to create different types of Expressions that will consume the interpreter context class.
    public interface Expression {
        String interpret(InterpreterContext ic);
    }

    //We will have two expression implementations, one to convert int to binary and other to convert int to hexadecimal format.
    public class IntToBinaryExpression implements Expression {

        private int i;

        public IntToBinaryExpression(int c) {
            this.i = c;
        }

        @Override
        public String interpret(InterpreterContext ic) {
            return ic.getBinaryFormat(this.i);
        }

    }

    public class IntToHexExpression implements Expression {

        private int i;

        public IntToHexExpression(int c) {
            this.i = c;
        }

        @Override
        public String interpret(InterpreterContext ic) {
            return ic.getHexadecimalFormat(i);
        }

    }


    //Now we can create our client application that will have the logic to parse the user input and pass it
    // to correct expression and then use the output to generate the user response.

    public class InterpreterClient {

        public InterpreterContext ic;

        public InterpreterClient(InterpreterContext i) {
            this.ic = i;
        }

        public String interpret(String str) {
            Expression exp = null;
            //create rules for expressions
            if (str.contains("Hexadecimal")) {
                exp = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
            } else if (str.contains("Binary")) {
                exp = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" "))));
            } else return str;

            return exp.interpret(ic);
        }
    }

    public static void main(String args[]) {
        Interpreter i = new Interpreter();

        String str1 = "28 in Binary";
        String str2 = "28 in Hexadecimal";

        InterpreterClient ec = i.new InterpreterClient(i.new InterpreterContext());
        System.out.println(str1 + "= " + ec.interpret(str1));
        System.out.println(str2 + "= " + ec.interpret(str2));


    }
}
