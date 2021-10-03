
import java.text.DecimalFormat;
import java.util.Random;

public class PerformanceTestArrays{





    public static void main(String[] args) throws InterruptedException {
        int Size = 1000;

        WarmupJVM();


        for(int t = 0;Size <= 20960000;t++) {
            if (Size <= 256000){
                while (runTest1(Size, 1)) ;
                Thread.sleep(500);
                while (runTest2(Size, 1)) ;
                Thread.sleep(500);}
            while (runTest3(Size,1));
            Size*=2;
            if(t%2==0)
                WarmupJVM();
        }




    }
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



    public static int range3(int[] numbers) {
        int max = numbers[0];
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




    static void WarmupJVM(){
        int Size = 30000;
        for(int i = 0;i<4;i++)
            while (runTest1(Size,0));
        while (runTest2(Size,0));
        while (runTest3(Size,0));
    }




    public static boolean runTest1(int size,int s){

        if(s==1){ System.out.println("Running first method with the size ["+size+"]...");}
        int[] ranges = new int[size]; // set the size here
        for (int i = 0;i<ranges.length;i++){
            ranges[i] = new Random().nextInt(100)+1;
        }
        long Start = 0;
        Start = System.currentTimeMillis();
        range1(ranges);// method 3 is fastest 1 is slowest
        long Finish = 0;
        Finish = System.currentTimeMillis();
        double MilliSec = (Finish - Start);
        DecimalFormat df = new DecimalFormat("#.#####");
        double Sec = (MilliSec/1000.0);
        String ms = df.format(MilliSec);
        String sec = df.format(Sec);
        if(s == 0){}else {
            System.out.println("**************************");
            System.out.println("Finished running the first method.");
            System.out.println("The time it took in Ms:" + (Finish - Start));
            System.out.println("The time it took in Seconds:" + sec);
            System.out.println("**************************");
            System.out.println("");
            System.out.println("");
        }
        Start = 0;
        Finish = 0;
        return false;
    }


    public static boolean runTest2(int size,int s){
        if(s==1){
            System.out.println("Running second method with the size ["+size+"]...");}
        int[] ranges = new int[size]; // set the size here
        for (int i = 0;i<ranges.length;i++){
            ranges[i] = new Random().nextInt(100)+1;
        }
        long Start = System.currentTimeMillis();
        range2(ranges);// method 3 is fastest 1 is slowest
        long Finish = 0;
        Finish = System.currentTimeMillis();
        double MilliSec = (Finish - Start);
        DecimalFormat df = new DecimalFormat("#.#####");
        double Sec = (MilliSec/1000.0);
        String ms = df.format(MilliSec);
        String sec = df.format(Sec);
        if(s==1) {
            System.out.println("**************************");
            System.out.println("Finished running second method.");
            System.out.println("The time it took in Ms:" + (Finish - Start));
            System.out.println("The time it took in Seconds:" + sec);
            System.out.println("**************************");
            System.out.println("");
            System.out.println("");
        }

        return false;
    }

    public static boolean runTest3(int size,int s){
        if(s == 1){
            System.out.println("Running third method with the size ["+size+"]...");}
        int[] ranges = new int[size]; // set the size here
        for (int i = 0;i<ranges.length;i++){
            ranges[i] = new Random().nextInt(100)+1;
        }
        long Start = System.currentTimeMillis();
        range3(ranges);// method 3 is fastest 1 is slowest
        long Finish = 0;
        Finish = System.currentTimeMillis();
        double MilliSec = (Finish - Start);
        DecimalFormat df = new DecimalFormat("#.#####");
        double Sec = (MilliSec/1000.0);
        String ms = df.format(MilliSec);
        String sec = df.format(Sec);

        if(s == 1) {
            System.out.println("**************************");
            System.out.println("Finished running third method.");
            System.out.println("The time it took in Ms:" + (Finish - Start));
            System.out.println("The time it took in Seconds:" + sec);
            System.out.println("**************************");

            System.out.println("");
            System.out.println("");
        }
        return false;
    }
}