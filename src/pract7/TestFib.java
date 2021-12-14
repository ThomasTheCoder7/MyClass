package pract7;
import java.util.Scanner;
// *******************************************************************
//	TestFib.java
//
//	A simple driver that uses the Fib class to compute the
//	nth element of the Fibonacci sequence.
// *******************************************************************
public class TestFib
{
    public static void main(String[] args)
    {
        int n, fib;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an integer: "); n = scan.nextInt();
        fib = Fib.fib2(n);
        System.out.println("Fib(" + n + ") is " + fib);
    }
}
