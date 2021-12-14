package pract7;

// *******************************************************************
//	Fib.java
//
//	A utility class that provide methods to compute elements of the
//	Fibonacci sequence.
// *******************************************************************
public class Fib
{

    //------------------------------------------------------------------
// Recursively computes fib(n)
//------------------------------------------------------------------
    public static int fib1(int n)
    {

        if(n>1){return fib1(n-1)+fib1(n-2);}
        return n;
    }


    public static int fib2(int n)
    {
        int[] a = new int[n];
        if(n < n){

        a[0] = 0;
        a[1] = 1;
        a[n] = fib2(n+1)+fib2(n+1);
        return a[n-1];}
        else return 0;
    }
}

