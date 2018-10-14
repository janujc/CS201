public class Common {
    private char[] letterCount (String a) {
        char[] letterArray = new char[a.length()];
        for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            letterArray[i] = x;
        }
        return letterArray;
    }
    private int match (String a, char[] b) {
        int counter = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            for (int j = 0; j < b.length; j++) {
                char d = b[j];
                if (c == d) {
                    b[j] = 0;
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }
    public int count (String a, String b) {
        int counter;
        char[] charArrayB;
        charArrayB = letterCount(b);
        counter = match(a, charArrayB);
        return counter;
    }
}
