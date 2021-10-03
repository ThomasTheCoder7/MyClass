package pract1;

import java.util.Scanner;

public class ReversingAnArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size YOU want for your array:");
        int size = Integer.parseInt(scan.nextLine());
        String[] array = new String[size];
        for(int i = 0; i<size;i++){
            System.out.print("Enter the element No."+i+" :");
            array[i] = scan.nextLine();
        }
        System.out.print("Before Reversing: ");
        PrintArray(array);
        String temp = "";
        int j = 1;
        for(int i = 0;i<size/2;i++){
             temp = array[i];
             array[i]=array[array.length-j];
             array[array.length-j]=temp;
            j++;
        }
        System.out.print("After Reversing: ");
        PrintArray(array);
    }



    static void PrintArray(Object[] array){
    System.out.print("{");
    for (int i = 0;i< array.length;i++) {
        if(i!= 0){ System.out.print(","); }
        System.out.print(array[i]);
    }
    System.out.print("}");
    System.out.println("");
}

}
