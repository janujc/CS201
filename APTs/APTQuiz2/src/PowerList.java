public class PowerList {
    public ListNode create(int n) {
        if (n == 1) return null;
        int num = 1;
        ListNode list = new ListNode(num, null);
        ListNode last = list;
        while (num * 2 < n) {
            num = num * 2;
            last.next = new ListNode(num, null);
            last= last.next;
        }
        return list;
    }
}
