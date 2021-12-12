package pract4;

 import java.io.IOException;
 import java.util.Scanner;

public class StackBracketTest {

    private String input;

    /**
     * Default Constructor
     */
    public StackBracketTest() {
        input = null;
    }

    /**
     * Alternate Constructor Sets Expression to be evaluated
     *
     * @param in string containing expression to be balanced
     */
    public StackBracketTest(String in) {
        this.input = in;
    }

    /**
     * Set string containing expression to be evaluated
     *
     * @param in string containing expression to be balanced
     */
    public void setExpression(String in) {
        input = in;
    }

    /**
     * Evaluate expression and determine correctness
     */
    public void check() {
        boolean cur = false,sqr=true,circ=true;
        int stackSize = input.length();
        StackArrayG<Character> theStack = new StackArrayG(Character.class,stackSize);
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                // if char is an opening bracket i.e. [({ then push onto stack
                case'[':
                    theStack.push(ch);
                    sqr = false;
                    break;
                case '(':
                    theStack.push(ch);
                    circ = false;
                    break;
                case '{':
                    theStack.push(ch);
                    cur  = false;
                    break;
                case')':
                    if(theStack.isEmpty()){

                        break;
                    }
                    theStack.pop();
                    circ = true;
                    break;
                case']':
                    if(theStack.isEmpty()){
                        break;
                    }
                    theStack.pop();
                    sqr = circ;
                    break;

                case'}':
                    if(theStack.isEmpty()){
                        break;
                    }
                    theStack.pop();
                    cur=circ&&sqr;
                    break;
                // if char is a closing bracket i.e. ])} then pop the top
                // element off stack (checking that stack is not empty)
                // and check that it is a matching opening bracket for
                // the current closing bracket
                // if it doesn’t match or the stack is empty then its and
                // invalid expression.
            }
        }
        boolean s = circ&&sqr&&cur;
        System.out.println(s);
        // Test that the stack is empty. If not the expression is invalid
    }

        // complete the following switch statement.


    /**
     * This main method implements a little interactive test program which when
     * executed repeatedly prompts the user for an expression and tests the
     * expression.
     */
    public static void main(String[] args) throws IOException {
        String input = "";
        // Declare a variable of type StackBracketTest and create
        StackBracketTest s = new StackBracketTest();

        // and assign to it and instance of StackBracketTest class.
        // Which would be the most appropriate constructor to use here?
        // note this is a do while loop which is different to a while
        // loop in that it will always execute at least once.
        // Can you determine what condition causes the loop to terminate?
        do {
            System.out.print("Enter string containing delimiters: ");
            // read a string from the console using the Scanner class.
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            s.setExpression(input);
            s.check();
            // can you determine what this if statement is doing?
            if (!input.equals("")) {
                // pass the string to the StackBracketTest object created
                // above using the most appropriate method.

                // Call the StackBracketTest check method.
                // Test result of check method and display result in form of
                // a message to the user e.g. “This statement is valid”
            }
        } while (!input.equals(""));
    }
}

