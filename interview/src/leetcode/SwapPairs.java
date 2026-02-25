package leetcode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode subHead = swapPairs(head.next.next);
        ListNode headNext = head.next;
        headNext.next = head;
        head.next = subHead;
        return headNext;
    }
}
