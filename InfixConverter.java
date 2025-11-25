/**
 * Converts an infix expression into postfix notation using a stack.
 * <p>
 * Tokens in the expression must be separated by spaces (e.g.,
 * {@code "3 + 4 * 2"}).
 * </p>
 * 
 * <p>
 * Example:
 * </p>
 * 
 * <pre>{@code
 * StackADT stack = new LinkedListBasedStack();
 * InfixConverter converter = new InfixConverter(stack);
 * String post = converter.convert("3 + 4 * 2");
 * // post is "3 4 2 * +"
 * }</pre>
 * 
 * @author Maverick Guinto
 * @version 1.0
 */
public class InfixConverter {

    /**
     * Stack used to hold operators during conversion.
     */
    private StackADT stack;

    /**
     * Constructs the converter using the given stack for operators.
     *
     * @param stack an implementation of {@code StackADT} to store operators
     */
    public InfixConverter(StackADT stack) {
        this.stack = stack;
    }

    /**
     * Converts an infix expression (tokens separated by spaces) into postfix
     * notation.
     *
     * @param infix the infix expression to convert
     * @return the converted postfix expression
     */
    public String toPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        String[] tokens = infix.split(" ");

        for (String token : tokens) {
            // If the token is a number, append it directly to postfix output
            if (isNumber(token)) {
                postfix.append(token).append(" ");
            }
            // Left parenthesis, push onto stack
            else if (token.equals("(")) {
                stack.push(token);
            }
            // Right parenthesis, pop until matching "("
            else if (token.equals(")")) {
                // pop until left parenthesis
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // remove "("
            }
            // Pop operators of higher or equal precedence, then push current
            else if (isOperator(token)) {
                // pop operators with >= precedence
                while (!stack.isEmpty()
                        && isOperator(stack.peek())
                        && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        // pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    /**
     * Returns {@code true} if the token is a number (operand).
     * 
     * @param s the token that is checked to be an operand
     */
    private boolean isNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }

    /**
     * Returns {@code true} if the token is an operator (+ - * /).
     * 
     * @param s the token that is checked to be an operator
     */
    private boolean isOperator(String s) {
        return "+-*/".contains(s);
    }

    /**
     * Used to check the operator precedence
     * Operator precedence: * and / = 2, + and - = 1.
     * 
     * @param op the operator that is checked for precedence
     */
    private int precedence(String op) {
        if (op.equals("*") || op.equals("/"))
            return 2;
        return 1;
    }
}
