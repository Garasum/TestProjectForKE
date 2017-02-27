package creational;

/**
 * Created by Orest on 2/23/2017.
 */
public class Prototype {

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
            // Continue Here 
            return null;
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
