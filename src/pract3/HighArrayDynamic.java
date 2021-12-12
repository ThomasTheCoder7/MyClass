package pract3;
public class HighArrayDynamic {
    private int nElems;
    private long[] a;
    private final int INITIALSIZE = 2;
    private int Capacity;

    public HighArrayDynamic()
    {
        Capacity = INITIALSIZE;
        a = new long[INITIALSIZE];
        nElems = 0;
    }
    public HighArrayDynamic(int capacity)
    {
        Capacity = capacity;
        a = new long[capacity];
        nElems = 0;
    }

    public void IncreaseSize(){
        Capacity*=2;
        long[] temparr = new long[Capacity];
        for (int i = 0;i<nElems;i++) {
            temparr[i] = a[i];
        }
        a=temparr;
    }
    public void add(long x) {
        if(nElems >= Capacity){
            IncreaseSize();
        }
        a[nElems]=x;
        nElems++;
    }

    public String toString()
    {
        String temp = "[" + a[0];
        for (int i = 1; i < nElems; i++)
        {
            temp = temp + "," + a[i];
        }
        temp = temp + "]";
        return temp;
    }
}




