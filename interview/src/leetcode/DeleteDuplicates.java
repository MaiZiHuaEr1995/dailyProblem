package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.val = 1;
        head.next.next = new ListNode(1);
        head.next.next.val = 1;
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        System.out.println(deleteDuplicates.deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            int val1 = cur.next.val;
            if (cur.next.val == cur.next.next.val) {
                while (cur.next != null && cur.next.val == val1) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
