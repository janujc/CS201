public class ListSum {
    public int sum(ListNode list, int thresh) {
        int count = 0;
        while (list != null) {
            if (list.info > thresh) count += list.info;
            list = list.next;
        }
        return count;
    }
}
