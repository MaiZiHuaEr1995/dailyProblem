package leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        addTwoNumbers.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x;
            if (l1 == null) {
                x = 0;
            } else {
                x = l1.val;
            }
            int y;
            if (l2 == null) {
                y = 0;
            }  else {
                y = l2.val;
            }
            int sum = x + y + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }
}
