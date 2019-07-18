package CodingInterview;

import structure.ListNode;

public class _25_MergeSortedLists {

    public static ListNode<Integer> merge(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        ListNode<Integer> head = null;
        if (head1.val < head2.val) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }
        ListNode<Integer> mergeNode = head;


        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                mergeNode.next = head1;
                head1 = head1.next;
                mergeNode = mergeNode.next;
            } else {
                mergeNode.next = head2;
                head2 = head2.next;
                mergeNode = mergeNode.next;
            }
        }
        if (head1 != null) {
            mergeNode.next = head1;
        }
        if (head2 != null) {
            mergeNode.next = head2;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> head1 = new ListNode<>(1);
        head1.next = new ListNode<>(3);
        head1.next.next = new ListNode<>(5);
        head1.next.next.next = new ListNode<>(7);
        ListNode<Integer> head2 = new ListNode<>(2);
        head2.next = new ListNode<>(4);
        head2.next.next = new ListNode<>(6);
        head2.next.next.next = new ListNode<>(8);
        System.out.println(head1);
        System.out.println(head2);
        ListNode<Integer> head = merge(head1, head2);
        System.out.println(head);
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }
}
