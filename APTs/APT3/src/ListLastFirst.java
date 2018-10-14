public class ListLastFirst {

    /**
     * count return length of list
     * @param list is a linked list
     * @return length of list
     */
    private int count (ListNode list) {
        int count = 0;
        while(list != null) {
            list = list.next;
            count++;
        }
        return count;
    }

    /**
     * moves the last element of a linked list to the front
     * @param list a linked list
     * @return a modified linked list
     */
    public ListNode move(ListNode list) {
        int count = count(list);
        if (count <= 1) return list;
        int counter = 0;

        // we want the first node in original list to be second node in our new list
        ListNode second = new ListNode(list.info, list.next);

        // loops through all the nodes
        while(list != null) {
            counter++;
            if (counter == count - 1){  // second to last node
                ListNode first = new ListNode(list.next.info, second); // makes .next of last node be "second"
                list.next = null;       // second to last node is now last -> .next = null
                return first;           // returns a linked list with last node now first node
            }
            list = list.next;
        }

        return list;
    }
}
