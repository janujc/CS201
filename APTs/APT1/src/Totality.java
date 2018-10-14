public class Totality {
    public int sum(int[] a, String stype){
        int esum = 0;
        int osum = 0;
        for (int k = 0; k < a.length; k++) {
            if (k % 2 == 0){
                esum += a[k];
            }
            else{
                osum += a[k];
            }
        }
        if (stype.equals("odd")) {
            return osum;
        }
        else if (stype.equals("even")) {
            return esum;
        }
        else {
            return esum + osum;
        }
    }
}
