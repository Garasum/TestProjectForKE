package structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orest on 2/24/2017.
 * <p>
 * Composite pattern is used where we need to treat a group of objects in similar way as a single object.
 * Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy.
 * This type of design pattern comes under structural pattern as this pattern creates a tree structure of group of objects.
 * <p>
 * This pattern creates a class that contains group of its own objects. This class provides ways to modify its group of same objects.
 */
public class Composite {

    /**
     * Step 1: Create Employee class having list of Employee objects.
     */

    public class Employee {
        private String name;
        private String depth;
        private Integer salary;
        private List<Employee> subordinates;

        //constructor
        public Employee(String name, String depth, Integer salary) {
            this.name = name;
            this.depth = depth;
            this.salary = salary;
            subordinates = new ArrayList<Employee>();
        }

        public void add(Employee e) {
            subordinates.add(e);
        }

        public List<Employee> getSubordinates() {
            return subordinates;
        }

        public String toString() {
            return ("Employee :[ Name : " + name + ", dept : " + depth + ", salary :" + salary + " ]");
        }
    }


    /**
     * Step 2: Use the Employee class to create and print employee hierarchy.
     */

    public static void main(String[] args) {
        Composite composite = new Composite();
        Employee CEO = composite.new Employee("John", "CEO", 30000);

        Employee headSales = composite.new Employee("Clark", "Head Sales", 20000);

        Employee headMarketing = composite.new Employee("Michel", "Head Marketing", 20000);

        Employee clerk1 = composite.new Employee("Laura", "Marketing", 10000);
        Employee clerk2 = composite.new Employee("Bob", "Marketing", 10000);

        Employee salesExecutive1 = composite.new Employee("Richard", "Sales", 10000);
        Employee salesExecutive2 = composite.new Employee("Rob", "Sales", 10000);


        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        /**
         *                            CEO
         *                           /   \
         *                  headSales     headMarketing
         *                /   \                   /   \
         * salesExecutive1  salesExecutive2   clerk1  clerk2
         */

        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);

            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }

    }
}
