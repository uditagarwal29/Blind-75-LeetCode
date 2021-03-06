class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode c;
        if (list1.val > list2.val) {
            c = list2;
            c.next = mergeTwoLists(list1, list2.next);
        } else {
            c = list1;
            c.next = mergeTwoLists(list1.next, list2);
        }

        return c;
    }
}
