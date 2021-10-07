package pract3;
public class HighArrayDynamic
{
    private int nElems;
    private long[] a;
    private final int INITIALSIZE = 20;

    public HighArrayDynamic()
    {
        a = new long[INITIALSIZE];
        nElems = 0;
    }
    public HighArrayDynamic(int capacity)
    {
        a = new long[capacity];
        nElems = 0;
    }


    public void add(long x)
    {
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
