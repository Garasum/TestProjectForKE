package temp.Collectinos;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Personn {
    private int age;

    public Personn(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public int compareTo(Person person) {
//        return this.age - person.age;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

class ComparePerson implements Comparator<Personn> {

    @Override
    public int compare(Personn o1, Personn o2) {
        return o1.getAge() - o2.getAge();
    }
}

public class UseComparator {
    public static void main(String[] args) {
        Set set = new TreeSet(new ComparePerson());
        set.add(new Personn(4));
        set.add(new Personn(6));
        set.add(new Personn(5));
        set.add(new Personn(2));
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
