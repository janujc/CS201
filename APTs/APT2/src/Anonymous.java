public class Anonymous {
    public int[] numLettersArray(String[] words) {
        int[] count = new int[256];
        for (String s : words) {
            String lowerS = s.toLowerCase();
            for (char c : lowerS.toCharArray()) {
                count[c] = count[c] + 1;
            }
        }
        return count;
    }

    public int[] numLetters(String words) {
        int[] count = new int[256];
        String lowerWords = words.toLowerCase();
        for (char c : lowerWords.toCharArray()) {
            count[c] = count[c] + 1;
        }
        return count;
    }

    public boolean isAlwaysGreaterThan(int[] a, int[] b) {
        boolean check = true;
        for (int i = 0; i < 256; i++) {
            if (i == 32) {
                continue;
            }
            if (a[i] < b[i]){
                check = false;
                break;
            }
        }
        return check;
    }

    public int howMany(String[] headlines, String[] messages) {
        int[] deck = numLettersArray(headlines);
        int counter = 0;
        for (String s : messages) {
            int[] match = numLetters(s);
            boolean check = isAlwaysGreaterThan(deck, match);
            if (check) {
                counter ++;
            }
        }
        return counter;
    }
}
