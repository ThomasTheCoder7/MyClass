package pract2;

import com.sun.jdi.DoubleValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class HiArray <T extends Comparable> {
    private T[] a;                 // ref to array a
    private int nElems;               // number of data items
    private int MaxIndex;
    private int MinIndex;
    private int index;
    private boolean noDup;
    private Class aClass;

    //-----------------------------------------------------------
    public  HiArray(Class c,int max)         // constructor
    {

        aClass = c;
        a = (T[]) Array.newInstance(c,max);
       // a =  (T[]) new Number[max];
        nElems = 0;                        // no items yet
    }
    //-----------------------------------------------------------
    public boolean find(T searchKey)
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

    public int findAll(T element) {
        int occ = 0;
        for (int i = 0; i < nElems; i++)
            if (a[i] == element) {
                occ++;
            }
        return occ;
    }

    public void insert(T value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //-----------------------------------------------------------

    public void insertOrdered(T value)    // put element into array
    {
        int j;
        for(j=0; j<nElems; j++)// find where it goes
            if(value.compareTo(a[j])==0)            // (linear search)
                break;
        for(int k=nElems; k>j; k--)    // move bigger ones up
            a[k] = a[k-1];
        a[j] = value;                  // insert it
        nElems++;                      // increment size
    }  // end insert()
    //-----------------------------------------------------------
    public boolean delete(T value)
    {
        int j;
        for(j=0; j<nElems; j++)        // look for it
            if( value == a[j])
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

    public int binarySearch(T searchKey) {
        int left = 0, right = nElems-1,pass=1;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (a[pivot] == searchKey) {
                printTrace(left,right,pivot,pass);
                return pivot;// found
            }
            else {
                if (searchKey.compareTo(a[pivot])==-1){
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
    public int deleteAll(T element){
        int times = findAll(element); //find out how many elements to delete in the array
        for(int i = 0; i < times;i++){
            delete(element);           // delete the elements
        }
        return times;
    }


    public int size() {
        return nElems;
    }

    public T max(){
        T max = a[0];

        for (int i = 0;i<nElems;i++){
            if(max.compareTo(a[i])==-1){
                max = a[i];
                MaxIndex = i;
            }

        }
        return max;
    }



    public T rank(int r){
        int i = 0,j=1,u=1;
        int rnk = nElems;
        boolean statement = true;
        for( i = 0;i<nElems-u;i++){
            j=i+1;
            if(a[j].compareTo(a[i])==1){
                swap(i,j);
                statement = false;
            }
            if(!statement&&j >= nElems-u){
                if(r==rnk){  return a[rnk-1]; }
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
                if (a[i].compareTo(a[j])==1) {
                    swap(i,j);
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
                if(a[j].compareTo(a[i])==1){swap(i,j);}
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
            if(a[j].compareTo(a[i])==-1){
                swap(i,j);
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







    public T min(){
        T min = a[0];

        for (int i = 0;i<nElems;i++){
            if(a[i].compareTo(min)==-1){
                min = a[i];
                MinIndex = i;
            }
        }
        return min;
    }

    //public double range(){ return max()-min(); }

    public int MaxIndex(){ return MaxIndex; }

    public int MinIndex(){ return MinIndex; }
/**
    public long sum(){
        int s = 0;
        for(int i =0;i<nElems;i++){ s+=a[i].doubleValue(); }
        return  s;
    }

    public double avg(){
        return (max().doubleValue()-min().doubleValue())/(nElems+0.0);
    }

    public double std(){
        double mean = sum()/(0.0+nElems);
        int s = 0;
        double div = 0;
        for(int i = 0;i<nElems;i++){
            s=s + (int) (Math.pow((a[i].doubleValue()-mean),2));
        }

        div = s/(nElems+0.0);


        return Math.sqrt(div);
    }
*/
    public void RemoveDuplicates(){
        T[] dupE = (T[]) new Number[nElems];
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
            T[] dupE = (T[]) Array.newInstance(aClass,nElems);
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
            if(a[i].compareTo(a[t+1])==-1||a[i]==a[t+1]){}
            else {return false;}
        }
        return true;
    }

    public void fillArrayRandom(){
        for(int i = 0;i<nElems;i++){
            Random r = new Random();

            a[i] = ReadNum(r.nextInt(100)+1);
        }
    }

    public void readIntFile(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        while (input.hasNext()) {
            Double next = input.nextDouble();




            insert(ReadNum(next));

        }// end while


    }

    private T ReadNum(Double next) {
        return (T) next;
    }
    private T ReadNum(Integer next) {
        return (T) next;
    }



    public void swap(int first,int second){
        T temp = (T) a[first];
        a[first] = a[second];
        a[second]  = temp;
    }

}
