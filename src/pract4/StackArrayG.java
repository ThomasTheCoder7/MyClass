package pract4;

import java.lang.reflect.Array;

public class StackArrayG<T> {
    private int capacity;        // size of stack array
    private T[] a;
    private int nElems; // top of stack
    
    //--------------------------------------------------------------
    public StackArrayG(Class c, int s) {         // constructor
        capacity = s;             // set array size
        a = (T[]) Array.newInstance(c,s) ; // create array
        nElems = 0;                // no items yet
    }
    //--------------------------------------------------------------
    public void push(T j) {    // put item on top of stack
        a[nElems] = j;     // increment top, insert item
        nElems++;
    }
    //--------------------------------------------------------------
    public T pop() {         // take item from top of stack
        int top = nElems - 1;
        T temp = a[top];
        nElems--;
        return temp;  // access item, decrement top
    }
    //--------------------------------------------------------------
    public T peek() {         // peek at top of stack
        int top = nElems - 1;
        return a[top];
    }
    //--------------------------------------------------------------
    public boolean isEmpty() {    // true if stack is empty
        if (nElems == 0) {
            return true;
        } else {
            return false;
        }
    }
    //--------------------------------------------------------------
    public boolean isFull() {    // true if stack is full
        return (nElems == capacity);
    }
//--------------------------------------------------------------
}  // end class StackArray
////////////////////////////////////////////////////////////////

