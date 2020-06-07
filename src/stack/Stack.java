package stack;

import java.util.EmptyStackException;

/**
 * Generic custom Stack class
 * @param <T>
 */
public class Stack<T> {
    private static class StackNode<T> {
        public T val;
        public StackNode<T> next;

        public StackNode(T data) {
            val = data;
        }
    }

    private StackNode<T> top;

    public void push(T item) {
        StackNode<T> t = new StackNode<>(item);
        t.next = top;
        top = t;
    }

    public T pop() {
        if(top == null)
            throw new EmptyStackException();
        return (top = top.next).val;
    }

    public T peek() {
        if(top == null)
            throw new EmptyStackException();
        return top.val;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
