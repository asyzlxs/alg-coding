package CodingInterview;

import structure.ListNode;

public class _18_02_DeleteDuplication {

    public static ListNode<Integer> deleteDuplication(ListNode<Integer> head) {
        if (head == null || head.next == null)
            return head;

        ListNode<Integer> pre = null;
        ListNode<Integer> cur = head;
        ListNode<Integer> next = cur.next;
        boolean deleteNode = false;

        while (next != null) {
            if (cur.val.equals(next.val)) {
                next = next.next;
                deleteNode = true;
            } else if (deleteNode) {
                if (pre == null) {
                    head = next;
                } else {
                    pre.next = next;
                }

                cur = next;
                next = cur.next;
                deleteNode = false;
            } else {
                pre = cur;
                cur = next;
                next = cur.next;
            }
        }
        if (deleteNode && pre != null)
            pre.next = null;
        else if (deleteNode && pre == null)
            head = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(1);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(2);
        head.next.next.next.next = new ListNode<>(2);
        head.next.next.next.next.next = new ListNode<>(3);
        head.next.next.next.next.next.next = new ListNode<>(3);
        System.out.println(head);
        head = deleteDuplication(head);
        System.out.println(head);

    }
}
