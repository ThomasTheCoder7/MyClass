package pract7;
import java.util.Scanner;
// *****************************************************************
//	BaseConversion.java
//
//	Recursively converts an integer from base 10 to another base
// ***************************************************************** import java.util.Scanner;
public class BaseConversion {
    public static void main(String[] args) {
        int base10Num;
        int base;
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Base Conversion Program");
        System.out.print("Enter an integer: ");
        base10Num = scan.nextInt();
        System.out.print("Enter the base: ");
        base = scan.nextInt();
        String s = convert(base10Num,base);
        System.out.println(s);
    }


    public static String convert(int num, int b) {
        int quotient = num / b;
        int remainder = num % b;
        String s="";
        if(quotient > 0){ s=convert(quotient,b);}
        return s+remainder;
    }
}

