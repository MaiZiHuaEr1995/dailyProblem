package leetcode;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode latter = dummyHead;
        ListNode cur = head;
        ListNode former = head;
        for (int i = 0; i < n; i++) {
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = cur;
            cur = cur.next;
        }
        latter.next = cur.next;
        return dummyHead.next;
    }
}
