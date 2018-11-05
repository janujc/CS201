import java.util.ArrayList;
import java.util.Collections;

public class Dirsort {
    public class Directory implements Comparable<Directory> {
        String[] dir;
        String dirString;

        public Directory(String s) {
            dir = s.split("/");
            dirString = s;
        }

        public String[] getDir() {
            return dir;
        }

        @Override
        public int compareTo(Directory d) {
            if (this.getDir().length == d.getDir().length) {
                for (int i = 0; i < this.getDir().length; i++) {
                    if (this.getDir()[i].compareTo(d.getDir()[i]) == 0) continue;
                    return this.getDir()[i].compareTo(d.getDir()[i]);
                }
            }
            else if (this.getDir().length < d.getDir().length) return -1;
            return 1;
        }

        @Override
        public String toString() {
            return dirString;
        }
    }

    public String[] sort(String[] dirs) {
        ArrayList<Directory> d = new ArrayList<>();

        for (String s : dirs) {
            d.add(new Directory(s));
        }

        Collections.sort(d);

        for (int i = 0; i < dirs.length; i++) {
            dirs[i] = d.get(i).toString();
        }

        return dirs;
    }
}
