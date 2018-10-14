public class SandwichBar {

    private boolean isIn (String s, String[] list) {
        for (String t : list) {
            if (t.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /*
    return true if each part of sandwich in available; false otherwise
     */

    public boolean canMake(String sandwich, String[] available){
        for (String s : sandwich.split(" ")) {
            if (! isIn(s, available)) {
                return false;
            }
        }
        return true;
    }

    public int whichOrder(String[] available, String[] orders){

        for (int i = 0; i < orders.length; i++) {
            if (canMake(orders[i], available)) {
                return i;
            }
        }
        return -1; //FIXME
    }
}
