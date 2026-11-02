package Ch;

import java.util.EmptyStackException;

/**
 * Stack that stores its elements as a chain of nodes.
 * Each node knows the node below it, so only the top node has to be stored.
 *
 * @param <T> type of the elements in the stack
 */
public class LinkedStack<T> implements SimpleStack<T> {

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
    }

    /**
     * One element of the chain together with the node below it.
     *
     * @param <T> type of the element
     */
    private static class Node<T> {

        /** The stored element. */
        private final T element;
        /** The node below this one, or null for the bottom node. */
        private final Node<T> below;

        /**
         * Creates a new node.
         *
         * @param element the stored element
         * @param below   the node below this one, or null for the bottom node
         */
        Node(T element, Node<T> below) {
            this.element = element;
            this.below = below;
        }
    }

    /** The top node, or null if the stack is empty. */
    private Node<T> top;
    /** Number of elements, stored so size() does not have to walk the chain. */
    private int size;

    /**
     * Puts a new node on top of the current top node.
     *
     * @param element the element to add
     */
    @Override
    public void push(T element) {
        top = new Node<>(element, top);
        size++;
    }

    /**
     * Removes the top node and returns its element. The node below becomes the new top.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T pop() {
        T element = peek();
        top = top.below;
        size--;
        return element;
    }

    /**
     * Returns the element of the top node without removing it.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.element;
    }

    /**
     * Returns the number of elements.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return size;
    }
}
