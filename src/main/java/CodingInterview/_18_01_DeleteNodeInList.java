package CodingInterview;

import structure.ListNode;

import java.util.List;

public class _18_01_DeleteNodeInList {

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        head.next = node2;
        node2.next = node3;
        System.out.println(head);
        head = deleteNode(head, node3);
        System.out.println(head);
        head = deleteNode(head, head);
        System.out.println(head);
    }

    private static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node) {
        if (head == node)
            return head.next;
        else if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        } else {
            ListNode<Integer> tmp = head;
            while (tmp.next != node) {
                tmp = tmp.next;
            }
            tmp.next = null;
        }
        return head;
    }
}
