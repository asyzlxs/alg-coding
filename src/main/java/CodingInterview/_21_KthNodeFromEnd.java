package CodingInterview;

import structure.ListNode;

public class _21_KthNodeFromEnd {

    public static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k){
        if (head == null)
            return null;
        ListNode<Integer> node = head;
        ListNode<Integer> ahead = head;
        while (k > 1){
            --k;
            ahead = ahead.next;
            if (ahead == null)
                return null;
        }
        while (ahead.next!=null){
            ahead = ahead.next;
            node = node.next;
        }

        return node;
    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        System.out.println(findKthToTail(head,1).val);
        System.out.println(findKthToTail(head,2).val);
        System.out.println(findKthToTail(head,3).val);
        System.out.println(findKthToTail(head,4));

    }
}
