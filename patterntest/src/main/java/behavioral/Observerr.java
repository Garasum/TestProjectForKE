package behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
 * Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified,
 * its depenedent objects are to be notified automatically
 */
public class Observerr {

    //Create Subject class.
    public class Subject {

        private List<Observer> observers = new ArrayList<Observer>();
        private int state;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
            notifyAllObservers();
        }

        public void attach(Observer observer) {
            observers.add(observer);
        }

        public void notifyAllObservers() {
            for (Observer observer : observers) {
                observer.update();
            }
        }
    }

    //Create Observer class
       public abstract class Observer {
        protected Subject subject;

        public abstract void update();
    }

    //Create concrete observer classes
    public class BinaryObserver extends Observer{

        public BinaryObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
        }
    }

    public class OctalObserver extends Observer{

        public OctalObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
        }
    }

    public class HexaObserver extends Observer{

        public HexaObserver(Subject subject){
            this.subject = subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
        }
    }

    //Use Subject and concrete observer objects.
    public static void main(String[] args) {
        Observerr r = new Observerr();

        Subject subject = r.new Subject();

        r.new HexaObserver(subject);
        r.new OctalObserver(subject);
        r.new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }


}
