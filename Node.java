/**
 * Represents a single node to be used in LinkedListBasedStack.
 * Stores a string value and a reference to the next node.
 * 
 * <p>
 * Example:
 * </p>
 *
 * <pre>{@code
 * Node n = new Node("A");
 * System.out.println(n.value); // "A"
 * System.out.println(n.next); // null
 * }</pre>
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
     * <p>
     * Example:
     * </p>
     *
     * <pre>{@code
     * Node n = new Node("Data");
     * }</pre>
     *
     * @param value the string value to store in this node
     */
    public Node(String value) {
        this.value = value;
        this.next = null;
    }
}
