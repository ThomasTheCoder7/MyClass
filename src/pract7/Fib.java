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
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2;i<a.length;i++)
        {
            a[i]=a[i-2]+a[i-1];
        }
        return a[a.length-1];
    }
}

