package leetcode;

public class OddEvenList {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 奇数节点头节点
        ListNode odd = head;
        // 奇数节点的下一个是偶数节点
        ListNode even = head.next;
        // 偶数节点头节点
        ListNode evenHead = even;
        // 从偶数节点开始遍历，如果当前节点为空，或者后一个节点为空，说明当前链表已经遍历完毕，不需要再遍历了
        while (even != null && even.next != null) {
            // 原来奇数节点的下一个节点是偶数节点
            odd.next = even.next;
            // 让 odd移动到最新的由奇数组成的链表的尾部
            odd = odd.next;
            // 原来偶数节点的下一个节点是奇数节点
            even.next = odd.next;
            // 让even移动到最新的由偶数组成的链表的尾部
            even = even.next;
        }
        // 右奇数节点组成的链表的尾部的 next 指针指向由偶数节点组成的链表的头部
        odd.next = evenHead;
        return head;
    }
}
