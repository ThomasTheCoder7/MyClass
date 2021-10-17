package pract3;

import pract3.NumbersArray;

public class NumberArrayTest {
    public static void main(String[] args) {
        NumbersArray n = new NumbersArray(15);
        n.insert(4);
        n.insert(4.4);
        n.insert(433);
        n.BubbleSort();
        System.out.println(n.rank(1));
        //n.display();
    }
}
