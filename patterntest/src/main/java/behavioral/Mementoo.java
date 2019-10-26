package behavioral;

import java.util.ArrayList;
import java.util.List;

//Memento pattern is used to restore state of an object to a previous state.
public class Mementoo {


    //Create Memento class
    public class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    //Create Originator class
    public class Originator {
        private String state;

        public void setState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public Memento saveStateToMemento() {
            return new Memento(state);
        }

        public void getStateFromMemento(Memento memento) {
            state = memento.getState();
        }
    }

    //Create CareTaker class
    public class CareTaker {
        private List<Memento> mementoList = new ArrayList<Memento>();

        public void add(Memento state){
            mementoList.add(state);
        }

        public Memento get(int index){
            return mementoList.get(index);
        }
    }

    //Use CareTaker and Originator objects.

    public static void main(String[] args) {
        Mementoo m = new Mementoo();

        Originator originator = m.new Originator();
        CareTaker careTaker = m.new CareTaker();

        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }

}
