package sc;

public class M {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        int o = 0;
        int[] b = ins(array,o);
        for (int k:
             b) {
            System.out.println(k);
        }
    }
    static int[] ins(int[] a,int o){
        int[] arr = new int[a.length];
        int t=0;
        int j = 1;
        for (int i=0;i<a.length-1;i++) {
            if(i>0){a[j]=t;}
            t=a[j];
            a[j]=a[i];
            j++;
        }
        a[0]=o;

    return a;}
}
