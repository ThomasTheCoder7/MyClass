package pract1;


import java.util.Random;

/**
 * PerformanceTest.java
 * A class to test performance of linear, quadric and cubic algorithms
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PerformanceTest {

    /**
     * Test linear performance
     *
     * @param   n  Size of test
     */
    public void linearTest(int n) {
        int loopcount=0;
        double starttime = System.nanoTime();
        System.out.print("O(" + n + ") took.. ");
        for (int i=0; i<n; i++)
            loopcount++;
        double endtime = System.nanoTime();;
        System.out.println(((endtime-starttime)) + "nano seconds");

    }

    /**
     * Test Quadratic performance O(N^2)
     *
     * @param   n  Size of test
     */
    public void quadraticTest(int n) {
        int loopcount=0;
        double starttime = System.nanoTime();
        System.out.print("O(" + (int)Math.pow(n,2) + ") took.. ");
        for (int i=0; i<n; i++)
            for(int j = 0;j<n;j++)
                loopcount++;
        double endtime = System.nanoTime();;
        System.out.println(((endtime-starttime)) + "nano seconds");
    }

    /**
     * Test Cubic Performance O(N^3)
     *
     * @param   n  Size of test
     */
    public void cubicTest(int n) {
        int loopcount=0;
        double starttime = System.nanoTime();
        System.out.print("O(" + (int)Math.pow(n,3) + ") took.. ");
        for (int i=0; i<n; i++)
            for(int j = 0;j<n;j++)
                for(int k = 0;k<n;k++)
                    loopcount++;
        double endtime = System.nanoTime();;
        System.out.println(((endtime-starttime)) + "nano seconds");
    }


    /**
     * Main Method
     *
     * @param   args  commandline parameters (optional)
     */
    public static void main(String args[]) {
        PerformanceTest p = new PerformanceTest();
            p.linearTest(10);
            p.quadraticTest(10);
            p.cubicTest(10);
        // call methods of object p (PerformanceTest) with
        // various sizes of N and see the performance differences.

    }
}
class performanceTestArrays {



// returns the range of values in the given array;
// the difference between elements furthest apart
// example: range({17, 29, 11, 4, 20, 8}) is 25

    public static int range1(int[] numbers) {
        int maxDiff = 0;     // look at each pair of values
        int diff = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                 diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return diff;
    }


    // returns the range of values in the given array;
// the difference between elements furthest apart
// example: range({17, 29, 11, 4, 20, 8}) is 25
    public static int range2(int[] numbers) {
        int diff=0;
        int maxDiff = 0;     // look at each pair of values
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                diff = Math.abs(numbers[j] - numbers[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        return diff;
    }


    // returns the range of values in the given array;
// example: range({17, 29, 11, 4, 20, 8}) is 25
    public static int range3(int[] numbers) {
        int max = numbers[0];     // find max/min values
        int min = max;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max - min;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1000,2000,4000,8000,16000,32000,64000,128000,256000,512000};
        for(int i = 0;i<arr.length;i++){
            int x = i;
            Thread thread1 = new Thread(new Runnable() {
                public void run() { runTest1(arr[x]); }});
            Thread thread2 = new Thread(new Runnable() {
                public void run() { runTest2(arr[x]); }});
            Thread thread3 = new Thread(new Runnable() {
                public void run() { runTest3(arr[x]); }});
            Thread.sleep(1000);
            thread1.start();
            while (thread1.isAlive()){}
            Thread.sleep(1000);
            thread2.start();
            while (thread2.isAlive()){}
            Thread.sleep(1000);
            thread3.start();
        }

    }

    public static void runTest1(int size){
        System.out.println("Running first method with the size ["+size+"]...");
        int[] ranges = new int[size]; // set the size here
        for (int i = 0;i<ranges.length;i++){
            ranges[i] = new Random().nextInt(100)+1;
        }
        long Start = System.nanoTime();
        range1(ranges);// method 3 is fastest 1 is slowest
        long Finish = System.nanoTime();
        long Sec = (Finish - Start)/1000000000;
        long MilliSec = (Finish - Start)/1000000;
        System.out.println("**************************");
        System.out.println("Finished running the first method.");
        System.out.println("The time it took in Ns:"+(Finish-Start));
        System.out.println("The time it took in Ms:"+MilliSec);
        System.out.println("The time it took in Seconds:"+Sec);
        System.out.println("**************************");

        System.out.println("");
        System.out.println("");

    }


    public static void runTest2(int size){
        System.out.println("Running second method with the size ["+size+"]...");
        int[] ranges = new int[size]; // set the size here
        for (int i = 0;i<ranges.length;i++){
            ranges[i] = new Random().nextInt(100)+1;
        }
        long Start = System.nanoTime();
        range2(ranges);// method 3 is fastest 1 is slowest
        long Finish = System.nanoTime();
        double Sec = (Finish - Start)/1000000000;
        long MilliSec = (Finish - Start)/1000000;
        System.out.println("**************************");
        System.out.println("Finished running second method.");
        System.out.println("The time it took in Ns:"+(Finish-Start));
        System.out.println("The time it took in Ms:"+MilliSec);
        System.out.println("The time it took in Seconds:"+Sec);
        System.out.println("**************************");


        System.out.println("");
        System.out.println("");



    }

    public static void runTest3(int size){
        System.out.println("Running third method with the size ["+size+"]...");
        int[] ranges = new int[size]; // set the size here
        for (int i = 0;i<ranges.length;i++){
            ranges[i] = new Random().nextInt(100)+1;
        }
        long Start = System.nanoTime();
        range3(ranges);// method 3 is fastest 1 is slowest
        long Finish = System.nanoTime();
        double Sec = (Finish - Start)/1000000000;
        long MilliSec = (Finish - Start)/1000000;
        System.out.println("**************************");
        System.out.println("Finished running third method.");
        System.out.println("The time it took in Ns:"+(Finish-Start));
        System.out.println("The time it took in Ms:"+MilliSec);
        System.out.println("The time it took in Seconds:"+Sec);
        System.out.println("**************************");

        System.out.println("");
        System.out.println("");


    }
}




