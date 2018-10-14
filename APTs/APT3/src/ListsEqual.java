public class ListsEqual {
    private int count (ListNode list) {
        int count = 0;
        while(list != null) {
            list = list.next;
            count++;
        }
        return count;
    }

    public int equal (ListNode a1, ListNode a2) {
        if (count(a1) != count(a2)) return 0;
        while (a1 != null) {
            if (a1.info != a2.info) return 0;
            a1 = a1.next;
            a2 = a2.next;
        }
        return 1;
    }
}
