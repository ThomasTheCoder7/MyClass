package pract2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HighArray
{
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items
    private int MaxIndex;
    private int MinIndex;
    private int index;
    private boolean noDup;


    //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
    //-----------------------------------------------------------
    public boolean find(long searchKey)
    {                              // find specified value
        int j;
        for(j=0; j<nElems; j++)            // for each element,
            if(a[j] == searchKey) {         // found item?
                break;   }                    // exit loop before end
        if(j == nElems)                    // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }  // end find()
    //-----------------------------------------------------------

    public int findAll(long element) {
        int occ = 0;
        for (int i = 0; i < nElems; i++)
            if (a[i] == element) {
                occ++;
            }
        return occ;
    }

    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //-----------------------------------------------------------
    public void insertOrdered(long value)    // put element into array
    {
        int j;
        for(j=0; j<nElems; j++)        // find where it goes
            if(a[j] > value)            // (linear search)
                break;
        for(int k=nElems; k>j; k--)    // move bigger ones up
            a[k] = a[k-1];
        a[j] = value;                  // insert it
        nElems++;                      // increment size
    }  // end insert()
    //-----------------------------------------------------------
    public boolean delete(long value)
    {
        int j;
        for(j=0; j<nElems; j++)        // look for it
            if( value == a[j] )
                break;
        if(j==nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for(int k=j; k<nElems; k++) // move higher ones down
                a[k] = a[k+1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()
    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }
    //-----------------------------------------------------------
    public int binarySearch(int searchKey) {
        int left = 0, right = nElems-1,pass=1;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (a[pivot] == searchKey) {
                printTrace(left,right,pivot,pass);
                return pivot;// found
            }
             else {
                if (a[pivot] < searchKey){
                    left = pivot + 1;  // search right
                    printTrace(left,right,pivot,pass);
                    pass++;
                }
                else {
                    printTrace(left, right, pivot, pass);
                    right = pivot - 1;  // search left
                    pass++;
                }
            }
        }
        System.out.println("Couldnt find "+searchKey +" in the array");
        return -1;
    }

    public void printTrace(int left,int right,int pivot,int pass){
        System.out.printf("Pass %d left = %d right = %d pivot = %d",pass,left,right,pivot);
        System.out.println("");
    }
    public int deleteAll(long element){
        int times = findAll(element); //find out how many elements to delete in the array
        for(int i = 0; i < times;i++){
            delete(element);           // delete the elements
        }
return times;
    }


    public int size() {
        return nElems;
    }

    public long max(){
        long max = a[0];

        for (int i = 0;i<nElems;i++){
            if(a[i]>max){
                max = a[i];
                MaxIndex = i;
            }

        }
    return max;
    }



    public long rank(int r){
        int i = 0,j=1,u=1;
        long temp = 0;
        int rnk = nElems;
        boolean statement = true;
        for( i = 0;i<nElems-u;i++){
            j=i+1;
            if(a[i]>a[j]){
                temp  = a[i];
                a[i] = a[j];
                a[j] = temp;
                statement = false;
            }
            if(!statement&&j >= nElems-u){
                if(r==rnk){ return a[rnk-1]; }
                rnk--;
                statement = true;
                u++;
                i = -1;
            }
        }
        return a[r-1];
    }


    public void selectionSort(){
        long temp = 0;
        int count = 0, j = 0;
        for (int i = 0; i < nElems; i++) {
            for (j = i; j < nElems; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                count++;
            }
        }
        System.out.println(count);
    }

    public void insertionSort(){
        int SortedArraySize = 0;
        long temp = 0;
        for(int i = 0;i<nElems;i++){
            for(int j = 0;j<SortedArraySize;j++){
                if(a[i]<a[j]){temp=a[i]; a[i]=a[j]; a[j] = temp;}
            }
            if(SortedArraySize < a.length){SortedArraySize++;}

        }
    }

    public void BubbleSort(){
        int i = 0,j=1,u=1,count=0;
        long temp = 0;
        boolean statement = true;
        for( i = 0;i<nElems-u;i++){
            j=i+1;
            if(a[i]>a[j]){
               temp  = a[i];
                a[i] = a[j];
                a[j] = temp;
                statement = false;
            }
            if(!statement&&j >= nElems-u){
                statement = true;
                u++;
                i = -1;
            }
            count++;
        }
        System.out.println("Steps:"+count);
  }







    public long min(){
        long min = a[0];

        for (int i = 0;i<nElems;i++){
            if(a[i]<min){
                min = a[i];
                MinIndex = i;
            }
    }
    return min;
    }

    public long range(){ return max()-min(); }

    public int MaxIndex(){ return MaxIndex; }

    public int MinIndex(){ return MinIndex; }

    public long sum(){
        int s = 0;
        for(int i =0;i<nElems;i++){ s+=a[i]; }
        return  s;
    }

    public double avg(){
        return (max()-min())/(nElems+0.0);
    }

    public double std(){
        double mean = sum()/(0.0+nElems);
        int s = 0;
        double div = 0;
        for(int i = 0;i<nElems;i++){
            s=s + (int) (Math.pow((a[i]-mean),2));
        }

        div = s/(nElems+0.0);


       return Math.sqrt(div);
    }

    public void RemoveDuplicates(){
        long[] dupE = new long[nElems];
        int spot = 0;
        for(int i =0;i<nElems;i++){
            for(int j = 0;j<nElems;j++){
                if(a[i]==a[j]&&i!=j){
                    dupE[spot]=a[i];
                    spot++;
                }
            }
        }
        if(spot <= 0){noDup = true; }
        for(int i = 0;i<dupE.length;i++){
            deleteAll(dupE[i]);
        }

    }
    public boolean checkUnique(){
        long[] dupE = new long[nElems];
        int spot = 0;
        for(int i =0;i<nElems;i++){
            for(int j = 0;j<nElems;j++){
                if(a[i]==a[j]&&i!=j){
                    dupE[spot]=a[i];
                    return false;
                }
            }
        }
    return true;
    }

    public boolean checkOrdered(){
        int t = 0;
        for(int i = 0;i<nElems-1;i++){
            t = i;
            if(a[i]<=a[t++]){}
            else {return false;}
        }
        return true;
    }

    public void fillArrayRandom(){
        for(int i = 0;i<nElems;i++){
            a[i] = new Random().nextInt(100)+1;
        }
    }

    public void readIntFile(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        while (input.hasNextInt()) {
            int next = input.nextInt();
            insert(next);

        }// end while


    }

    public void swap(int i,int j){
        int temp;


    }


}  // end class HighArray
