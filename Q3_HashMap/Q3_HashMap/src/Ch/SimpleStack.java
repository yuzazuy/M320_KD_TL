package Ch;

import java.util.EmptyStackException;

/**
 * Simple stack data type (LIFO: last in, first out).
 * The last element that was pushed is the first one that is popped.
 * Generic: {@code T} is the type of the elements, e.g. {@code SimpleStack<String>}.
 * The interface only says what a stack can do; {@link ArrayStack} and {@link LinkedStack}
 * store the elements in different ways, and code that uses the interface works with both.
 *
 * @param <T> type of the elements in the stack
 */
public interface SimpleStack<T> {

    /**
     * Puts an element on top of the stack.
     *
     * @param element the element to add
     */
    void push(T element);

    /**
     * Removes the top element and returns it.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    T pop();

    /**
     * Returns the top element without removing it.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    T peek();

    /**
     * Returns the number of elements.
     *
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Checks if the stack has no elements.
     *
     * @return true if the stack is empty
     */
    default boolean isEmpty() {
        return size() == 0;
    }
}
