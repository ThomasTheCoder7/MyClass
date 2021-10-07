package pract2;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

public class HighArrayApp {
    public static void main(String[] args) throws FileNotFoundException {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
       // Class<HiArray>c = HiArray.class;
        Class<Double> c = Double.class;
        HiArray<Double> arr1 = new HiArray(c,maxSize);
        arr = new HighArray(maxSize); // create the array

       // arr1.insert(15);
        arr1.insert(26.0);
        arr1.insert(33.3);
        //arr1.insert(200);
        //arr1.insert(33);
       // arr1.BubbleSort();
        arr1.display();



        arr.insert(25);
        arr.insert(30);
        arr.insert(30);
        arr.insert(10);
        arr.insert(1);
        arr.insert(60);
        arr.insert(0);
        arr.insert(2);
        arr.insert(3);
        arr.insert(150);
        arr.insert(-1);
        arr.RemoveDuplicates();
        arr.display();                // display items
/*
        int searchKey = 35;           // search for item
        if( arr.find(searchKey) )
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
        //arr.RemoveDuplicates();
        System.out.println(arr.checkUnique());

        System.out.println(arr.std());
        //arr.fillArrayRandom();

        arr.BubbleSort();
        arr.display();
        System.out.println(arr.rank(3));
       // arr.display();

        // display items again

        //arr.readIntFile("/home/jawad/Documents/test.txt");
       // System.out.println("");
      //  arr.display();

 */


    }  // end main()
}  // end class HighArrayApp