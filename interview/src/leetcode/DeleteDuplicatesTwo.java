package leetcode;

public class DeleteDuplicatesTwo {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode cur) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = cur;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else  {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
