/*
 *   Author: Januario Carreiro
 *   Date: September 1, 2018
 */

public class DNAMaxNucleotide {
    public int match(String s, String nuc) {
        /*
         * creates an int counter that
         * counts instances of nuc in
         * individual strings
         */
        int basicCounter = 0;
        char nucleotide = nuc.charAt(0);
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c == nucleotide) {
                basicCounter++;
            }
        }
        return basicCounter;
    }
    public String max(String[] strands, String nuc) {
        String maximum = "";
        int[] matchCounter = new int[strands.length];
        for (int i = 0; i < strands.length; i++) {
            String s = strands[i];
            matchCounter[i] = match(s, nuc);
        }
        int maxValue = 0;
        int maxLength = 0;
        for (int i = 0; i < strands.length; i++) {
            if (matchCounter[i] > maxValue) {
                maxValue = matchCounter[i];
                maximum = strands[i];
                maxLength = strands[i].length();
            }
            else if (strands[i].length() > maxLength && matchCounter[i] == maxValue && matchCounter[i] != 0){
                maxLength = strands[i].length();
                maximum = strands[i];
            }

        }
        return maximum;
    }
}

