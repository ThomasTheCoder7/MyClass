package pract1;

import java.util.Scanner;
public class Sales
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of sales people you want:");
        int SALESPEOPLE = scan.nextInt();
        int[] sales = new int[SALESPEOPLE]; int sum;
        int Highest=0,placeMax=0,Minimum=1,placeMin=1;
        for (int i=0; i<sales.length; i++) {
        int t=i;
         t = ++t;
        System.out.print("Enter sales for salesperson " + t + ": "); sales[i] = scan.nextInt();
    }
        System.out.println("\nSalesperson Sales"); System.out.println("	");
        Minimum = sales[0];
        sum = 0;

        for (int i=0; i<sales.length; i++)
        {
            int t=i;
            t = ++t;
            System.out.println("	" + t + "	" + sales[i]); sum += sales[i];
            if(Highest<sales[i]){Highest = sales[i];placeMax = t;}
            if(Minimum>sales[i]){Minimum = sales[i];placeMin = t;}
            t++;
        }

        System.out.println("\nTotal sales: " + sum);
        System.out.println("\nAverage sales: "+ Average(sum,sales.length));
        System.out.println("Salesperson "+placeMax+" had the highest sale with "+Highest+"$");
        System.out.println("Salesperson "+placeMin+" had the lowest sale with "+Minimum+"$");

        System.out.print("Enter a value to see how many salespersons exceeded your value:");
        int x = scan.nextInt();
        System.out.println("");

        for (int i = 0;i< sales.length;i++){
            int t=i;
            t = ++t;
            if(sales[i] >= x){
                System.out.println("	" + t + "	" + sales[i]); sum += sales[i];
            }
        }

    }

    static double Average(double sum,double length){
        return sum/length;
    }
}

