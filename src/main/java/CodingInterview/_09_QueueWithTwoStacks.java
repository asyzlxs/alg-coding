package CodingInterview;

import java.util.Stack;

public class _09_QueueWithTwoStacks<T> {

    public Stack<T> s1 = new Stack<>();
    public Stack<T> s2 = new Stack<>();

    public void appendTail(T val) {
        s1.push(val);
    }

    public T deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty())
            return null;
        return s2.pop();
    }

    public static void main(String[] args) {
        _09_QueueWithTwoStacks<Integer> myQueue = new _09_QueueWithTwoStacks<>();
        myQueue.appendTail(1);
        myQueue.appendTail(2);
        myQueue.appendTail(3);
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        myQueue.appendTail(4);
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
        System.out.println(myQueue.deleteHead());
    }
}
