import java.util.EmptyStackException;

/**
 * Array based implementation of StackADT.
 * Uses dynamic resizing when array becomes full.
 * 
 * <p>
 * Example:
 * </p>
 * 
 * <pre>{@code
 * StackADT stack = new ArrayBasedStack();
 * stack.push("A");
 * stack.push("B");
 * System.out.println(stack.pop()); // prints "B"
 * System.out.println(stack.peek()); // prints "A"
 * }</pre>
 * 
 * @author Maverick Guinto
 * @version 1.0
 */
public class ArrayBasedStack implements StackADT {

    /**
     * The array that stores the stack elements.
     * Automatically resizes when full.
     */
    private String[] data;

    /**
     * Index of the top element of the stack.
     * When stack is empty, {@code top == -1}.
     */
    private int top;

    /**
     * Constructs a new empty stack with a starting capacity of 10.
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * StackADT stack = new ArrayBasedStack();
     * System.out.println(stack.isEmpty()); // true
     * }</pre>
     */
    public ArrayBasedStack() {
        data = new String[10];
        top = -1;
    }

    /**
     * Adds an element to the top of the stack.
     * If the array is full, the array is resized to double its current capacity.
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * StackADT stack = new ArrayBasedStack();
     * stack.push("hello");
     * stack.push("world");
     * }</pre>
     * 
     * @param item the string value to push onto the stack
     */
    @Override
    public void push(String item) {
        // Resize if array is full
        if (top == data.length - 1) {
            resize();
        }

        // Add item to top of stack
        top++;
        data[top] = item;
    }

    /**
     * Removes and returns the top element of the stack.
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * StackADT stack = new ArrayBasedStack();
     * stack.push("A");
     * stack.push("B");
     * String popped = stack.pop(); // "B"
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

        String value = data[top];
        data[top] = null;
        top--;
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
     * StackADT stack = new ArrayBasedStack();
     * stack.push("X");
     * String top = stack.peek(); // "X"
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

        return data[top];
    }

    /**
     * Returns whether the stack contains no elements.
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * StackADT stack = new ArrayBasedStack();
     * boolean empty = stack.isEmpty(); // true
     * stack.push("A");
     * empty = stack.isEmpty(); // false
     * }</pre>
     * 
     * @return {@code true} if stack has no elements
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Doubles the size of the underlying array.
     */
    private void resize() {
        String[] newData = new String[data.length * 2];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }
}
