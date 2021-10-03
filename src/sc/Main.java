package sc;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws AWTException {
    int[] i = {2,3,4,5};
    insert(i,1);

    }

    static void insert(int[] x,int t){
    int [] temp = new int[x.length+1];
    int k = 1;
    for(int i =0;i<x.length;i++){

        temp[k] = x[i];
        k++;

    }
    temp[0] = t;


    }
}
