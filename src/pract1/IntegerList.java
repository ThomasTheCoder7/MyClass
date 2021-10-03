package pract1;

// ***************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create & fill
// a list of integers.
//
// ***************************************************************
public class IntegerList
{
    int[] list; //values in the list
    int Size;
    int Capacity=5;

    //-------------------------------------------------------
//create a list of the given size
//-------------------------------------------------------
    public IntegerList(int size) {
        Size = size;
        while (Capacity<Size){
            Capacity*=2;
        }
        list = new int[Capacity];
    }

    public IntegerList(int[] array) {
        list = array;
    }

    //-------------------------------------------------------
//fill array with integers between 1 and 100, inclusive
//-------------------------------------------------------
    public void randomize()
    {
        for (int i=0; i<list.length; i++)
            list[i] = (int)(Math.random() * 100) + 1;
    }

    //-------------------------------------------------------
//print array elements with indices
//-------------------------------------------------------
    public void print()
    {
        for (int i=0; i<Size; i++) System.out.println(i + ":\t" + list[i]);
    }

    public void IncreaseSize(){
        while (Capacity<=Size){
            Capacity*=2;
        }
        int[] tempArray = new int[Capacity];
        for(int i = 0;i< list.length;i++){
            tempArray[i]=list[i];
        }
        list=tempArray;
    }
    public void addElement(int newVal){
        while (Size >= Capacity) {
            IncreaseSize();
        }
        list[Size]=newVal;
        Size++;
    }
    public int[] RemoveFirst(int newVal,boolean t){
        int i = 0;
        int place = 0;
        boolean replace = false;
        while(true){
            if(i>=Size){ break; }
            if(list[i]==newVal){
                place = i;
                replace = true;
                break;
            }
            i++;
        }
        int temp=0;
        if(replace){
            for(int x = place;x<list.length-1;x++){
                temp=x;
                list[x]=list[++temp];
            }
            int[] tempArray = new int[list.length];
            for (int m = 0;m<Size-1;m++){
                tempArray[m]=list[m];

            }
            list = tempArray;
            Size -=1;
            i=0;

        }
    return list; }

    public boolean RemoveFirst(int newVal){
        int i = 0;
        int place = 0;
        boolean replace = false;
        while(true){
            if(i>=Size){ break; }
            if(list[i]==newVal){
                place = i;
                replace = true;
                break;
            }
            i++;
        }
        int temp=0;
        if(replace){
            for(int t = place;t<list.length-1;t++){
                temp=t;
                list[t]=list[++temp];
            }
            int[] tempArray = new int[list.length];
            for (int m = 0;m<Size-1;m++){
                tempArray[m]=list[m];

            }
            list = tempArray;
            Size -=1;
            i=0;
            return true;
        }else{
            i=0;
            System.out.println("Couldn't find "+newVal+" in the list");
            return false;
        }
    }
    public void RemoveAll(int NewVal){
        int j = 0;
        boolean found = false;
        for(int i = 0;i<Size;i++){
            if(list[i]==NewVal){
                j++;
                found= true;
            }
        }
        if(found){
            for (int i = 0;i< j;i++){
                RemoveFirst(NewVal);
            }
            System.out.println("Removed all "+NewVal+"s from the list");
        }else{
            System.out.println("Couldn't find "+NewVal+" in the list");
        }

    }


}




// ***************************************************************
// IntegerListTest.java
//
// Provide a menu-driven tester for the IntegerList class.
//
// *************************************************************** import java.util.Scanner;


