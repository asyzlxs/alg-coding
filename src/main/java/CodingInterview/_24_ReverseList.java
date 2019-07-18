package CodingInterview;

import structure.ListNode;

import java.util.List;

public class _24_ReverseList {

    public static ListNode<Integer> reverseList(ListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;
        ListNode<Integer> cur = head;
        ListNode<Integer> pre = null;
        ListNode<Integer> post = head.next;
        while (post != null) {
            cur.next = pre;
            pre = cur;
            cur = post;
            post = post.next;

        }
        cur.next = pre;

        return cur;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(head);
        System.out.println(head.next);
        System.out.println(head.next.next);
        head = reverseList(head);
        System.out.println(head);
        System.out.println(head.next);
        System.out.println(head.next.next);
    }
}
