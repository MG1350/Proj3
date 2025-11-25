/**
 * Evaluates a postfix expression using a stack.
 * <p>
 * Tokens in the postfix expression must be separated by spaces.
 * </p>
 * 
 * <p>
 * Example:
 * </p>
 * 
 * <pre>{@code
 * StackADT stack = new ArrayBasedStack();
 * PostfixEvaluator evaluator = new PostfixEvaluator(stack);
 * int result = evaluator.evaluate("3 4 2 * +"); // returns 11
 * }</pre>
 * 
 * @author Maverick Guinto
 * @version 1.0
 */
public class PostfixEvaluator {

    /**
     * Stack used to store operands during evaluation.
     */
    private StackADT stack;

    /**
     * Constructs a postfix evaluator using the given stack for operands.
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * StackADT stack = new LinkedListBasedStack();
     * PostfixEvaluator eval = new PostfixEvaluator(stack);
     * }</pre>
     *
     * @param stack an implementation of {@code StackADT} to store operands
     */
    public PostfixEvaluator(StackADT stack) {
        this.stack = stack;
    }

    /**
     * Evaluates a postfix expression and returns its integer result.
     * <p>
     * The expression must be valid and tokens must be separated by spaces.
     * </p>
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * PostfixEvaluator eval = new PostfixEvaluator(new ArrayBasedStack());
     * int value = eval.evaluate("10 2 6 * +"); // returns 22
     * }</pre>
     *
     * @param postfix the postfix expression to evaluate
     * @return the integer value resulting from evaluating the expression
     */
    public int evaluate(String postfix) {
        String[] tokens = postfix.split(" ");

        for (String t : tokens) {

            if (isNumber(t)) {
                stack.push(t);
            }

            else if (isOperator(t)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int result = apply(a, b, t);
                stack.push(Integer.toString(result));
            }
        }

        return Integer.parseInt(stack.pop());
    }

    /**
     * Returns {@code true} if the token is a number (operand).
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * isNumber("5"); // true
     * isNumber("+"); // false
     * }</pre>
     * 
     * @param s the token that is checked to be an operand
     */
    private boolean isNumber(String s) {
        return Character.isDigit(s.charAt(0));
    }

    /**
     * Returns {@code true} if the token is an operator (+ - * /).
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * isOperator("*"); // true
     * isOperator("12"); // false
     * }</pre>
     * 
     * @param s the token that is checked to be an operator
     */
    private boolean isOperator(String s) {
        return "+-*/".contains(s);
    }

    /**
     * Applies the given operator to two integer operands.
     * 
     * <p>
     * Example:
     * </p>
     * 
     * <pre>{@code
     * apply(3, 4, "*"); // returns 12
     * apply(8, 2, "-"); // returns 6
     * }</pre>
     *
     * @param a  the first operand (left-hand side)
     * @param b  the second operand (right-hand side)
     * @param op the operator to apply, one of (+ - * /)
     * @return the result of applying the operator to the operands
     */
    private int apply(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }
}
