package pract4;

public class StackApp {
    public static void main(String[] args) {
        /*
        StackArray theStack = new StackArray(10);  // make new stack
        theStack.push(20);               // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        while (!theStack.isEmpty()) {     // until it's empty,
            long value = theStack.pop(); // delete item from stack
            System.out.print(value);      // display it
            System.out.print(" ");
        }  // end while
        System.out.println("");
        */
        StackArrayG<Double> S = new StackArrayG<>(Double.class,10);
        S.push(20.33);               // push items onto stack
        S.push(40.5);
        S.push(20.1);
        S.push(40.6);
        while (!S.isEmpty()) {     // until it's empty,
            Double value = S.pop(); // delete item from stack
            System.out.print(value);      // display it
            System.out.print(" ");
        }  // end while
        System.out.println("");
    }  // end main()
}  // end class StackApp
////////////////////////////////////////////////////////////////
