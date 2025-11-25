
/**
 * Linked list based stack implementation using Node objects
 * 
 * <p>
 * Example:
 * </p>
 *
 * <pre>{@code
 * StackADT stack = new LinkedListBasedStack();
 * stack.push("A");
 * stack.push("B");
 * String top = stack.pop();  // returns "B"
 * }</pre>
 * 
 * @author Maverick Guinto
 * @version 1.0
 */
import java.util.EmptyStackException;

public class LinkedListBasedStack implements StackADT {

    /**
     * Reference to the top node of the stack.
     * When the stack is empty, {@code top == null}.
     */
    private Node top;

    /**
     * Constructs an empty linked list based stack.
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * StackADT stack = new LinkedListBasedStack();
     * }</pre>
     */
    public LinkedListBasedStack() {
        top = null;
    }

    /**
     * Adds a new element onto the top of the stack by creating a new node
     * and linking it to the existing top node.
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * stack.push("A");
     * stack.push("B");
     * }</pre>
     * 
     * @param item the string value to push onto the stack
     */
    @Override
    public void push(String item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * stack.push("A");
     * stack.push("B");
     * String x = stack.pop(); // x = "B"
     * }</pre>
     * 
     * @return the string at the top of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    @Override
    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        String value = top.value;
        top = top.next; // remove the node
        return value;
    }

    /**
     * Returns, but does not remove, the top element of the stack.
     *
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * stack.push("A");
     * String x = stack.peek(); // x = "A" (stack unchanged)
     * }</pre>
     * 
     * @return the string at the top of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    @Override
    public String peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.value;
    }

    /**
     * Returns whether the stack contains no elements.
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * stack.isEmpty(); // true initially
     * stack.push("A");
     * stack.isEmpty(); // false
     * }</pre>
     *
     * @return {@code true} if the stack is empty,
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
