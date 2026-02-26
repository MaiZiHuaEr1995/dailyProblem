package leetcode;

public class ReverseBetween {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        int i = 1;
        while (i < m) {
            pre = pre.next;
            cur = cur.next;
            i++;
        }
        for (int  j = 0; j < n - m; j++) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummyHead.next;
    }
}
