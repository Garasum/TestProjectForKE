package creational;

/**
 * Created by Orest on 2/23/2017.
 *
 * Failed Attempt to make Prototype
 *
 * Class needs to "implements Cloneable"
 * then override Clone method  to work correctly
 */
public class Prototype_Failed {

    public class CalendarPrototype {
        public CalendarPrototype CloneObject() throws CloneNotSupportedException {
            Object copyOfPrototype = this.clone();
            return (CalendarPrototype) copyOfPrototype;
        }
    }

    public class CalendarEvent extends CalendarPrototype {
        public Attendee[] attendees;
        public Priority priority;
        //public DateTime startDateAndTime;

        public CalendarPrototype CloneObject(){
            CalendarPrototype copy = this.CloneObject();
            Attendee[] copiedAttendees = attendees.clone();
            //copy =


            return copy;
        }
    }


    public class Attendee {
        public String firstName;
        public String lastName;
        public String emailAdress;
    }

    public class Priority {
        private Integer priority;

        private Priority(Integer priority) {
            this.priority = priority;
        }

        public Object CloneObject() throws CloneNotSupportedException {
            return this.clone();
        }

        public Priority High() {
            return new Priority(1);
        }

        public Priority Low() {
            return new Priority(-1);
        }

        public void SetPriorityValue(Integer priority) {
            this.priority = priority;
        }

        public boolean IsHigh() {
            return priority > 0;
        }
    }


}
