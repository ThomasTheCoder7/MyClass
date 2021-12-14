package pract2;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;
import pract1.Person;
public class HighArrayApp {
    public static void main(String[] args) throws FileNotFoundException {
        int maxSize = 1;            // array size
        HighArray arr;                // reference to array
       // Class<HiArray>c = HiArray.class;
        //HiArray<Person> arr1 = new <Person>HiArray(Person.class,maxSize);
        arr = new HighArray(maxSize); // create the array

/*

        Person p1 = new Person("Noah",5,180);
        Person p2 = new Person("Saad",27,190);
       // arr1.insert(15);
        arr1.insert(p1);
        arr1.insert(p2);
        arr1.insert(p1);
        arr1.insert(p1);
        System.out.println(arr1.findAll(p1));
        //arr1.insert(200);
        //arr1.insert(33);
       // arr1.BubbleSort();
        arr1.display();
        System.out.println(arr1.rank(2));
        arr1.di
        splay();
*/

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
       // arr.addfirst(-555);
        arr.RemoveAt(0);
        long[] x = arr.toArray();
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