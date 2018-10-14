public class RemoveMin {
    /**
     * min returns the minimum value in linked list of integers
     * @param list is a linked list of integers
     * @return the minimum value
     */
    private int min (ListNode list){
        int min = list.info;    // min is value of first node
        while (list != null) {
            if (min > list.info) min = list.info;   // if list.info smaller than min, replaces min
            list = list.next;
        }
        return min;
    }

    /**
     * returns a new list with minimum value of orginial list removed
     * @param list is a linked list of integers
     * @return a linked list without the node that contained minimum value
     */
    public ListNode remove (ListNode list) {
        int min = min(list);    // min value in list

        // special case if min value is first node
        if ((list.next != null) && (list.info == min)){
            ListNode replace = new ListNode(list.next.info, list.next.next);
            return replace;
        }

        // all other cases
        ListNode first = list;
        while (list != null) {
            if ((list.next == null) && (list.info == min)) {
                return null;
            }
            else if ((list.next.next == null) && (list.info != min)) {
                list.next = null;
                return first;
            }
            else if ((list.next.next != null) && (list.next.info == min)){
                list.next = list.next.next;
                return first;
            }
            list = list.next;
        }

        // there should always be a min value returned in the while loop, but nonetheless if it fails
        // we return the original list
        return first;
    }
}
