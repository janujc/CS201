import java.util.HashMap;

public class DonorStats {
    private HashMap<String, Integer> uniqueCandidates(String[] donations) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s1 : donations) {
            String[] a = numberSeperator(s1);
            String b = nameSeperator(s1);
            if (!map.containsKey(b)) {
                map.put(b, 0);
            }
            for (String s2 : a) {
                map.put(b, map.get(b) + Integer.parseInt(s2));
            }
        }
        return map;
    }

    private HashMap<String, Integer> donationCount(String[] donations) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s1 : donations) {
            String[] a = numberSeperator(s1);
            String b = nameSeperator(s1);
            if (!map.containsKey(b)) {
                map.put(b, 0);
            }
            for (String s2 : a) {
                map.put(b, map.get(b) + 1);
            }
        }
        return map;
    }

    private String[] numberSeperator(String donations) {
        String temp[] = {""};
        for (int i = 0; i < donations.length(); i++) {
            if (donations.charAt(i) != ':') {
                continue;
            } else return donations.substring(i + 1, donations.length()).split(",");
        }
        return temp;
    }

    private String nameSeperator(String donations) {
        String temp = "";
        for (int i = 0; i < donations.length(); i++) {
            if (donations.charAt(i) != ':') {
                continue;
            } else return donations.substring(0, i);
        }
        return temp;
    }

    public String[] calculate(String[] donations) {
        HashMap<String, Integer> map1 = uniqueCandidates(donations);
        HashMap<String, Integer> map2 = donationCount(donations);
        String[] str = new String[map1.size()];
        int counter = 0;
        for (String s : map1.keySet()) {
            str[counter] = s + ":" + map2.get(s) + ":" + map1.get(s);
            counter++;
        }
        return str;
    }
}

//    public static void main(String[] args) {
//        String[] s = {"fred:1,2,3", "ethel:4,5,6", "fred:3,3", "ethel:9"};
//        DonorStats test = new DonorStats();
//        String[] a = test.numberSeperator(s[0]);
//        String b = test.nameSeperator(s[0]);
//        for (String str : a) {
//            System.out.println(str);
//        }
//        System.out.println(b);
//    }
//}
