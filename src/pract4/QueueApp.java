package pract4;

public class QueueApp {
    public static void main(String[] args) {
      /*
        QueueArray theQueue = new QueueArray(10);  // make new stack
        theQueue.enqueue(20);               // push items onto stack
        theQueue.enqueue(40);
        theQueue.enqueue(60);
        theQueue.enqueue(80);
        while (!theQueue.isEmpty()) {     // until it's empty,
            long value = theQueue.dequeue(); // delete item from stack
            System.out.print(value);      // display it
            System.out.print(" ");
        }  // end while
        System.out.println("");
        */
        QueueArrayG<Double> Q = new QueueArrayG<>(Double.class,10);
        Q.enqueue(0.5);               // push items onto stack
        Q.enqueue(4.550);
        Q.enqueue(1.20);
        Q.enqueue(80.20);

        while (!Q.isEmpty()) {     // until it's empty,
            Double value = Q.dequeue(); // delete item from stack
            System.out.print(value);      // display it
            System.out.print("");
        }  // end while
        System.out.println("");

    }  // end main()
}  // end class StackApp
