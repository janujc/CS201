import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashTaggery {
    private String lettersOnly(String s){
        int counter = s.length() + 1;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetter(s.charAt(i))) counter--;
        }
        return s.substring(0, counter);
    }

    private String[] seperateStrings(String message){
        String[] newMessage = message.split(" ");
        int count = 0;
        for (int i = 0; i < newMessage.length; i++) {
            char[] ca = newMessage[i].toCharArray();
            char first = ca[0];
            if (first == '#') {
                count++;
            }
        }
        String[] hashTags = new String[count];
        int counter = 0;
        for (int j = 0; j < newMessage.length; j++) {
            char[] ca = newMessage[j].toCharArray();
            for (int k = 0; k < ca.length; k++){
                char first = ca[k];
                if (first == '#'){
                    hashTags[counter] = lettersOnly(newMessage[j]);
                    counter++;
                }
            }
        }
//        for (int k = 0; k < hashTags.length; k++) System.out.println("First loop " + hashTags[k]); //FIXME
        return hashTags;
    }

    private boolean matchTag(String[] tags, String[] hashTags){
        Set<String> s1 = new HashSet<>(Arrays.asList(tags));
        Set<String> s2 = new HashSet<>(Arrays.asList(hashTags));
        s1.retainAll(s2);
        int counter = 0;
        for (String s : s1){
            counter ++;
//            System.out.println("String in # " + s); FIXME
        }
        if (counter == 0) {
            return false;
        }
        return true;
    }

    public String maxTag(String[] tags, String[] messages) {
        double threshold = messages.length / 4.0 * 3.0;
        double counter = 0.0;
        for (int i = 0; i < messages.length; i++){
            String[] a = seperateStrings(messages[i]);
            if (matchTag(tags, a)) counter += 1.0;
        }
//        System.out.println(counter); FIXME
        if (counter >= threshold) return "tagged";
        return "missed";
    }

//    public static void main(String[] args) {
//        String[] s = {"#duke", "#compsci", "#fun", "hashtag", "#hash", "#tag"};
//        String[] t = {"We are @duke and #duke #compsci is #hashtag fun!", "We are #duke. We have all the #fun. We #hash and call #hashCode.", "#hash #tag and hashcodes are part of #compsci", "duke compsci fun is predicated on hashtaggery and #tags"};
//        HashTaggery test = new HashTaggery();
//        test.maxTag(s, t);
//    }
}
