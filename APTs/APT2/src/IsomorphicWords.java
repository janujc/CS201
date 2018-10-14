public class IsomorphicWords {
    private int charCount(String word){
        int count = 0;
        for (char c : word.toCharArray()) {
            count++;
        }
        return count;
    }

    private String numEquiv(String word) {
        char[] oldWord = word.toCharArray();
        char[] newWord = word.toCharArray();
        char letter = oldWord[0];
        int letterNumber = 1;
        for (int i = 0; i < charCount(word); i++){
            for (int j = 0; j < word.length(); j++) {
                char charLetter = (char) letterNumber;
                if (letter == oldWord[j]) {
                    newWord[j] = charLetter;
                }
            }
            letterNumber++;
            for (int k = 1; k < word.length(); k++){
                if(Character.isLetter(newWord[k])){
                    letter = newWord[k];
                    break;
                }
            }
        }
        String letterString = new String(newWord);
        return letterString;
    }

    private String[] newString(String[] words){
        String[] integerWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            integerWords[i] = numEquiv(words[i]);
        }
        return integerWords;
    }

    private int match(String[] words) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            String a = words[i];
            for (int j = 0; j < words.length; j++) {
                String b = words[j];
                if (a.equals(b) && j != i) {
                    counter++;
                }
            }
            words[i] = "0";
        }
        return counter;
    }

    public int countPairs(String[] words) {
        String[] newWords = newString(words);
        return match(newWords);
    }

}
