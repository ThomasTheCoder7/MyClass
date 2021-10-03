package pract2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileReaderSample {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter file name");
        String s = in.nextLine();
        Scanner input = new Scanner(new File(s));
        int[] arr = new int[100];
        int i = 0;
        while (input.hasNextInt()) {
            int next = input.nextInt();
            arr[i] = next;
            i++;
        }// end while
        int nElems = i;
// Print the array contents
        System.out.println("Array Contents");
        for (i = 0; i < nElems; i++) {
            System.out.println(i + "\t" + arr[i]);
        }// end for
    }// end main
}// end class
