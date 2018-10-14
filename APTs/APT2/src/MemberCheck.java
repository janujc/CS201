import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MemberCheck {
    private Set<String> intersection(Set<String> s1, Set<String> s2) {
        Set<String> tempS = new HashSet<>(s1);
        tempS.retainAll(s2);
        return tempS;
    }
    public String[] whosDishonest(String[] club1,
                                  String[] club2,
                                  String[] club3) {
        Set<String> result = new HashSet<>();
        Set<String> s1 = new HashSet<>(Arrays.asList(club1));
        Set<String> s2 = new HashSet<>(Arrays.asList(club2));
        Set<String> s3 = new HashSet<>(Arrays.asList(club3));

        result.addAll(intersection(s1, s2));
        result.addAll(intersection(s1, s3));
        result.addAll(intersection(s2, s3));
        String[] ret = result.toArray(new String[0]);
        Arrays.sort(ret);
        return ret;
    }
}
