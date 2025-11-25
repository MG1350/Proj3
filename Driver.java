import java.util.EmptyStackException;

public class Driver {
    public static void main(String[] args) {

        // testing Underlying Stack Implementations.
        StackADT linkedStack = new LinkedListBasedStack();
        StackADT arrayStack = new ArrayBasedStack();

        System.out.println("Testing LinkedListBasedStack");
        testStackOperations(linkedStack);

        System.out.println("Testing ArrayBasedStack");
        testStackOperations(arrayStack);


        System.out.println("Testing Infix-To-Postfix on LinkedListBasedStack");
        System.out.print("--------------------------------------------------\n");
        StackADT operatorStack = new LinkedListBasedStack();
        StackADT valueStack = new LinkedListBasedStack();
        testInfixToPostfix(operatorStack, valueStack);

        System.out.println("Testing Infix-To-Postfix on ArrayBasedStack");
        System.out.print("--------------------------------------------------\n");
        operatorStack = new ArrayBasedStack();
        valueStack = new ArrayBasedStack();
        testInfixToPostfix(operatorStack, valueStack);

    }

    // Utility Method to test Infix-To-Postfix problem
    public static void testInfixToPostfix(StackADT operatorStack, StackADT valueStack) {

        InfixConverter converter = new InfixConverter(operatorStack);
        PostfixEvaluator evaluator = new PostfixEvaluator(valueStack);

        // Define test cases: {infix expression, expected postfix, expected result}
        String[][] testCases = {
                {"3 + 4", "3 4 +", "7"},
                {"10 + 2 * 6", "10 2 6 * +", "22"},
                {"100 * 2 + 12", "100 2 * 12 +", "212"},
                {"100 * ( 2 + 12 )", "100 2 12 + *", "1400"},
                {"100 * ( 2 + 12 ) / 14", "100 2 12 + * 14 /", "100"},
                {"( 5 + 3 ) * ( 12 / 4 )", "5 3 + 12 4 / *", "24"},
                {"50 + ( 5 * ( 3 + 2 ) )", "50 5 3 2 + * +", "75"},
                {"( 3 + 4 ) * ( 5 - 2 )", "3 4 + 5 2 - *", "21"},
                {"( ( 2 + 3 ) * ( 5 + 6 ) )", "2 3 + 5 6 + *", "55"},
                {"( 10 + ( 6 / 2 ) ) * 3", "10 6 2 / + 3 *", "39"},
                {"( 8 + ( 2 * ( 3 + 1 ) ) ) * 2", "8 2 3 1 + * + 2 *", "32"},
                {"( ( ( 1 + 2 ) + 3 ) * 2 )", "1 2 + 3 + 2 *", "12"},
                {"( 4 + 5 ) * ( 6 + 7 ) - 8", "4 5 + 6 7 + * 8 -", "109"},
                {"( 7 + 3 ) * ( 5 + 2 ) / ( 2 + 1 )", "7 3 + 5 2 + * 2 1 + /", "23"}
        };

        for (String[] test : testCases) {
            String infix = test[0];
            String expectedPostfix = test[1];  // Get expected postfix
            int expected = Integer.parseInt(test[2]);  // Get expected result after evaluating the postfix

            // Convert to Postfix
            String postfix = converter.toPostfix(infix);

            // Check if the generated postfix matches the expected postfix
            if (postfix.equals(expectedPostfix)) {
                System.out.println("PASS: Postfix conversion for \"" + infix + "\" = " + postfix);
            } else {
                System.out.println("FAIL: Postfix conversion for \"" + infix + "\" => Got: " + postfix + ", Expected: " + expectedPostfix);
            }

            // Evaluate Postfix expression
            int result = evaluator.evaluate(postfix);
            if (result == expected) {
                System.out.println("PASS: Evaluation for \"" + infix + "\" = " + result);
            } else {
                System.out.println("FAIL: Evaluation for \"" + infix + "\" => Got: " + result + ", Expected: " + expected);
            }

            System.out.print("--------------------------------------------------\n");
        }
    }

    // Utility method for testing Stack implementations
    public static void testStackOperations(StackADT stack) {
        // Test isEmpty on a new stack
        if (stack.isEmpty()) {
            System.out.println("PASS: Stack is empty initially.");
        } else {
            System.out.println("FAIL: Stack should be empty initially.");
        }

        // Push elements
        stack.push("A");
        stack.push("B");
        stack.push("C");

        if (!stack.isEmpty()) {
            System.out.println("PASS: Stack is not empty after pushing elements.");
        } else {
            System.out.println("FAIL: Stack should not be empty after pushing elements.");
        }

        if ("C".equals(stack.peek())) {
            System.out.println("PASS: Top element is 'C' after pushing A, B, C.");
        } else {
            System.out.println("FAIL: Top element should be 'C'. Got: " + stack.peek());
        }

        // Pop and check value
        String popped = stack.pop();
        if ("C".equals(popped)) {
            System.out.println("PASS: Popped value is 'C'.");
        } else {
            System.out.println("FAIL: Popped value should be 'C'. Got: " + popped);
        }

        if ("B".equals(stack.peek())) {
            System.out.println("PASS: Top is now 'B' after popping.");
        } else {
            System.out.println("FAIL: Top should be 'B'. Got: " + stack.peek());
        }

        // Pop remaining elements
        stack.pop(); // pops B
        stack.pop(); // pops A

        if (stack.isEmpty()) {
            System.out.println("PASS: Stack is empty after popping all elements.");
        } else {
            System.out.println("FAIL: Stack should be empty after popping all elements.");
        }

        // Test popping from empty stack
        try {
            stack.pop();
            System.out.println("FAIL: Expected EmptyStackException when popping from empty stack.");
        } catch (EmptyStackException e) {
            System.out.println("PASS: Caught EmptyStackException when popping from empty stack.");
        }

        // Test peeking from empty stack
        try {
            stack.peek();
            System.out.println("FAIL: Expected EmptyStackException when peeking from empty stack.");
        } catch (EmptyStackException e) {
            System.out.println("PASS: Caught EmptyStackException when peeking from empty stack.");
        }
        System.out.print("--------------------------------------------------\n");
    }


}
