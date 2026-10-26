package Ch;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Simple stack data type (LIFO: last in, first out).
 * The last element that was pushed is the first one that is popped.
 * Generic: {@code T} is the type of the elements, e.g. {@code SimpleStack<String>}.
 *
 * @param <T> type of the elements in the stack
 */
public class SimpleStack<T> {

    /** Elements of the stack, the top is at the end of the list. */
    private ArrayList<T> elements = new ArrayList<>();

    /**
     * Puts an element on top of the stack.
     *
     * @param element the element to add
     */
    public void push(T element) {
        elements.add(element);
    }

    /**
     * Removes the top element and returns it.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        // The top element is the last one in the list
        return elements.remove(elements.size() - 1);
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    /**
     * Checks if the stack has no elements.
     *
     * @return true if the stack is empty
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns the number of elements.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return elements.size();
    }
}
