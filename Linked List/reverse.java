
class reverse {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node recursiveReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = recursiveReverse(head.next);
        // Node nextHead = head.next;
        // nextHead.next = head.next;
        // above two lines can be written in one line
        head.next.next = head; /// 5->4->NULL , here 5 is head, 5 ke next ka next means 4 ka next
                               // which is currently pointing to null, should point to current head which is 5
        head.next = null; // current head should point to null , so we get NULL<-5<-4
        return newHead;

    }

    public static void main(String[] args) {
        
    }
}