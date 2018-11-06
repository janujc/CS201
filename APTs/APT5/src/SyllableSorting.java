import java.util.ArrayList;
import java.util.Collections;

public class SyllableSorting {
    private String myVowels = "aeiou";

    public class Syllable implements Comparable<Syllable> {
        ArrayList<String> syl = new ArrayList<>();
        String sylString;

        public Syllable(String s) {
            sylString = s;
            String[] temp = s.split("");
            int count = 0;
            boolean vowel = false;
            for (int i = 0; i < s.length(); i++) {
                if (!myVowels.contains(temp[i]) && !vowel) {
                    count++;
                }
                if (!myVowels.contains(temp[i]) && vowel) {
                    syl.add(s.substring(i - count, i));
                    vowel = false;
                    count = 1;
                }
                if (myVowels.contains(temp[i])) {
                    vowel = true;
                    count++;
                }
                if (i == s.length() - 1) {
                    syl.add(s.substring(i - count + 1, i + 1));
                }
            }
        }

        public ArrayList<String> getSyl() {
            return syl;
        }

        public String getSylString() {
            return sylString;
        }

        @Override
        public int compareTo(Syllable s) {
            ArrayList<String> sylCopy = new ArrayList<>(this.getSyl());
            ArrayList<String> otherSylCopy = new ArrayList<>(s.getSyl());
            Collections.sort(sylCopy);
            Collections.sort(otherSylCopy);
            int size;
            if (sylCopy.size() > otherSylCopy.size()) size = otherSylCopy.size();
            else size = sylCopy.size();
            for (int i = 0; i < size; i++) {
                if (sylCopy.get(i).compareTo(otherSylCopy.get(i)) != 0) {
                    return sylCopy.get(i).compareTo(otherSylCopy.get(i));
                }
                if (i == size - 1 && sylCopy.size() < otherSylCopy.size()) {
                    return -1;
                }
                if (i == size - 1 && sylCopy.size() > otherSylCopy.size()) {
                    return 1;
                }
            }
            for (int j = 0; j < size; j++) {
                if (this.getSyl().get(j).compareTo(s.getSyl().get(j)) != 0) {
                    return this.getSyl().get(j).compareTo(s.getSyl().get(j));
                }
            }
            return 0;
        }

        @Override
        public String toString(){
            return sylString;
        }
    }

    public String[] sortWords(String[] words) {
        ArrayList<Syllable> S = new ArrayList<>();

        for (String s : words) {
            S.add(new Syllable(s));
        }

        Collections.sort(S);

        for (int i = 0; i < S.size(); i++) {
            words[i] = S.get(i).toString();
        }

        return words;
    }
}
