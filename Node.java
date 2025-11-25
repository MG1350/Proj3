/**
 * Represents a single node to be used in LinkedListBasedStack.
 * Stores a string value and a reference to the next node.
 */
public class Node {
    /**
     * The string value stored in this node.
     */
    String value;

    /**
     * The reference to the next node in the list.
     * When no next node, {@code next == null}.
     */
    Node next;

    /**
     * Creates a node storing the given string value.
     *
     * @param value the string value to store in this node
     */
    public Node(String value) {
        this.value = value;
        this.next = null;
    }
}
