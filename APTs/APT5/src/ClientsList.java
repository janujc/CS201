import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClientsList {
    public class Person implements Comparable<Person> {
        String first;
        String last;
        public Person(String s) {
            if (! s.contains(",")) {
                first = s.split(" ")[0];
                last = s.split(" ")[1];
            }
            else {
                first = s.split(", ")[1];
                last = s.split(", ")[0];
            }
        }
        public String getFirst() {
            return first;
        }
        public String getLast() {
            return last;
        }

        @Override
        public int compareTo(Person o) {
            if (this.getLast().compareTo(o.getLast()) == 0) {
                return this.getFirst().compareTo(o.getFirst());
            }
            return this.getLast().compareTo(o.getLast());
        }

        @Override
        public String toString() {
            return this.getFirst() + " " + this.getLast();
        }
    }

    public String[] dataCleanup(String[] names) {
        ArrayList<Person> people = new ArrayList<>();

        for (String s : names) {
            people.add(new Person(s));
        }

        Collections.sort(people);

        for (int i = 0; i < names.length; i++) {
            names[i] = people.get(i).toString();
        }

        return names;
    }
}
