/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // Let fast pointer reach to kth Position from starting
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //this case is for linked lists of length 0,1,2
        if(fast==null){
            return slow.next;
        }
        //set slow pointer just before nth node from end
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
}
