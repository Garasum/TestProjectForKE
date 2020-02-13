package temp.Collectinos;

import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

public class UseComparable {

    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add(new Person(4));
        set.add(new Person(6));
        set.add(new Person(4));
        set.add(new Person(2));
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
