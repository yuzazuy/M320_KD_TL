package Ch;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Stack that stores its elements in an {@link ArrayList}.
 * The top of the stack is the end of the list, so push and pop never move other elements.
 *
 * @param <T> type of the elements in the stack
 */
public class ArrayStack<T> implements SimpleStack<T> {

    /**
     * Creates an empty stack.
     */
    public ArrayStack() {
    }

    /** Elements of the stack, the top is at the end of the list. */
    private final List<T> elements = new ArrayList<>();

    /**
     * Adds the element to the end of the list.
     *
     * @param element the element to add
     */
    @Override
    public void push(T element) {
        elements.add(element);
    }

    /**
     * Removes the last element of the list and returns it.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    /**
     * Returns the last element of the list without removing it.
     *
     * @return the top element
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    /**
     * Returns the number of elements.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return elements.size();
    }
}
