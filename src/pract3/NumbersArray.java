package pract3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class NumbersArray <T extends Number> implements NumbersMethods {
    private T[] a;
    private int nElems;
    private int MaxIndex;
    private int MinIndex;
    private int index;
    private int InitSize=5;
    private int Capacity;
    private boolean noDup;
    private Class aClass;

    public NumbersArray(Class c){

    }
    public NumbersArray(int initSize){
        this.Capacity = initSize;
        a = (T[]) new Number[Capacity];
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

    public void IncreaseSize(){
        Capacity*=2;
        T[] temparr = (T[]) new Number[Capacity];
        for (int i = 0;i<nElems;i++) {
            temparr[i] = a[i];
        }
        a=temparr;
    }
    public void insert(T value)    // put element into array
    {
        if(nElems >= Capacity){
            IncreaseSize();
        }
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
    //-----------------------------------------------------------

    public void insertOrdered(T value)    // put element into array
    {
        int j;
        for(j=0; j<nElems; j++)// find where it goes
            if(a[j]==value)           // (linear search)
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


    public boolean delete(T value,int i)
    {
        int j=i;
        {
            for(int k=j; k<nElems; k++) // move higher ones down
                a[k] = a[k+1];
            nElems--;                   // decrement size
            return true;
        }
    }

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
                if (a[pivot].doubleValue() < searchKey.doubleValue()){
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

    public Number max(){
        T max = a[0];

        for (int i = 0;i<nElems;i++){
            if(a[i].doubleValue()>max.doubleValue()){
                max = a[i];
                MaxIndex = i;
            }

        }
        return max;
    }



    public Number rank(int r){
        int i = 0,j=1,u=1;
        T temp;
        int rnk = nElems;
        boolean statement = true;
        for( i = 0;i<nElems-u;i++){
            j=i+1;
            if(a[i].doubleValue()<a[j].doubleValue()){
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
    int range = 2;
    long[] temparr=new long[range];


    public void insertionSort(){
        long temp=0;
        for(int i = 0;i<range;i++){

        }
    }

    public void BubbleSort(){
        int i = 0,j=1,u=1,count=0;
        T temp;
        boolean statement = true;
        for( i = 0;i<nElems-u;i++){
            j=i+1;
            if(a[i].doubleValue()>a[j].doubleValue()){
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

    }







    public Number min(){
        T min = a[0];

        for (int i = 0;i<nElems;i++){
            if(a[i].doubleValue()<min.doubleValue()){
                min = a[i];
                MinIndex = i;
            }
        }
        return min;
    }

    public Number range(){ return max().doubleValue()-min().doubleValue(); }

    public int MaxIndex(){ return MaxIndex; }

    public int MinIndex(){ return MinIndex; }

    public Number sum(){
        double s = 0;
        for(int i =0;i<nElems;i++){ s+=a[i].doubleValue(); }
        return  s;
    }

    public double avg(){
        return (max().doubleValue()-min().doubleValue())/(nElems+0.0);
    }

    public double std(){
        double mean = sum().doubleValue()/(0.0+nElems);
        int s = 0;
        double div = 0;
        for(int i = 0;i<nElems;i++){
            s=s + (int) (Math.pow((a[i].doubleValue()-mean),2));
        }

        div = s/(nElems+0.0);


        return Math.sqrt(div);
    }

    public void RemoveDuplicates(){
        for(int i = 0;i<nElems;i++){
            for(int j = 0;j<nElems;j++){
                if(a[i]==a[j]&&i!=j){delete(a[i],j);}
            }
        }
    }

    public boolean checkUnique(){
        T[] dupE = (T[]) new Number[nElems];
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
            if(a[i].doubleValue()<=a[t++].doubleValue()){}
            else {return false;}
        }
        return true;
    }

    public void fillArrayRandom(){
        Number r = 0;
        for(int i = 0;i<nElems;i++){
            r = new Random().nextInt(100)+1;
            a[i] = (T)r;
        }
    }

    public void readIntFile(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        while (input.hasNextInt()) {
            Number next = input.nextDouble();

            insert((T)next);

        }// end while


    }

    public void Shift(String s,int n){
        if (s.equals("Right")||s.equals("right")){
            for(int i = n;i>0;i--)
                a[i] = a[i-1];
        }
        else{
            for(int i = n;i<nElems;i++) {a[i] = a[i+1];}
        }
    }
    public void addfirst(T n){
        nElems++;
        Shift("Right",nElems);
        a[0] = n;
    }
    public void RemoveFirst(){Shift("Left",nElems);}

    public void RemoveAt(int index){
        nElems--;
        Shift("Left",index);
    }

    public T get(int index) {
        return a[index];
    }

    public void set(int index,T val) {
        a[index] = val;
    }

    public T[] toArray(){
        return a;
    }

    public void clear(){
        nElems = 0;
    }

    public void swap(int first,int second){
        T temp = (T) a[first];
        a[first] = a[second];
        a[second]  = temp;
    }
}
