/**
 * StackADT Interface defines the abstract behavior of a stack data structure
 * that stores String elements.
 */
public interface StackADT {

    /**
     * Pushes an item onto the top of the stack.
     *
     * @param item the String item to be pushed onto the stack
     */
    public abstract void push(String item);


    /**
     * Removes and returns the item at the top of the stack.
     *
     * @return the String item removed from the top of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public abstract String pop();


    /**
     * Returns the item at the top of the stack without removing it.
     *
     * @return the String item at the top of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public abstract String peek();


    /**
     * Checks whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public abstract boolean isEmpty();
}
