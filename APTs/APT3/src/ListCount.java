public class ListCount {
    public int count (ListNode list) {
        int count = 0;
        while(list != null) {
            list = list.next;
            count++;
        }
        return count;
    }
}
