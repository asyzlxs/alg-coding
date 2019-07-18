package CodingInterview;

import structure.ListNode;

import java.util.List;

public class _23_EntryNodeInListNode {

    public static ListNode<Integer> meetingNode(ListNode<Integer> head) {
        if (head == null)
            return null;

        ListNode<Integer> node1 = head.next;
        if (node1 == null)
            return null;
        ListNode<Integer> node2 = node1.next;

        while (node1 != null && node2 != null) {
            if (node1.val.equals(node2.val))
                return node1;
            node1 = node1.next;
            node2 = node2.next;
            if (node2 != null)
                node2 = node2.next;
        }
        return null;
    }


    public static ListNode<Integer> entryNodeOfLoop(ListNode<Integer> head) {
        if (head == null)
            return null;

        ListNode<Integer> meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;
//        System.out.println(meetingNode.val);

        int nodesInLoop = 1;
        ListNode<Integer> node1 = meetingNode;
        ListNode<Integer> node2 = head;
        while (node1.next != meetingNode) {
            node1 = node1.next;
            ++nodesInLoop;
        }
        node1 = head;
        for (int i = 0; i < nodesInLoop; ++i) {
            node1 = node1.next;
        }
//        System.out.println("node1 val : " + node1.val);
//        System.out.println("node2 val : " + node2.val);
        while (!node1.val.equals(node2.val)){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    public static void main(String[] args) {
        //    1->2->3->4->5->6
        //          ↑_______↓
        ListNode<Integer> head = new ListNode<>(1);
        head.next= new ListNode<>(2);
        ListNode<Integer> node = new ListNode<>(3);
        head.next.next = node;
        node.next = new ListNode<>(4);
        node.next.next = new ListNode<>(5);
        node.next.next.next = new ListNode<>(6);
        node.next.next.next.next = node;
        ListNode<Integer> meet = entryNodeOfLoop(head);
        if(meet==null)
            System.out.println("没有环");
        else
            System.out.println("环的入口值:"+meet.val);
    }
}
