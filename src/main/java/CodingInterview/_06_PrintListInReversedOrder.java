package CodingInterview;

import structure.ListNode;

import java.util.Stack;

public class _06_PrintListInReversedOrder {

    public static void printListReversingly_Iteratively(ListNode<Integer> head) {
        if (head == null)
            return;
        Stack<ListNode<Integer>> st = new Stack<>();
        ListNode<Integer> temp = head;
        while (temp != null) {
            st.push(temp);
            temp = temp.next;
        }
        while (!st.empty()) {
            int top = st.pop().val;
            System.out.println(top);
        }
    }

    public static void printListRevesingly_Recursively(ListNode<Integer> head) {
        if (head != null){
            if(head.next != null){
                printListRevesingly_Recursively(head.next);
            }
            System.out.println(head.val);
        }


    }

    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        printListRevesingly_Recursively(head);

        printListReversingly_Iteratively(head);

    }
}
