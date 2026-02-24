package leetcode;

public class RemoveElements {
    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(0);
        RemoveElements r = new RemoveElements();
        r.removeElements(headA, 2);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
