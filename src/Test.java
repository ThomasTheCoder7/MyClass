import java.util.Arrays;
import java.util.Vector;

public class Test {

    public static void main(String[] args) {
int[] array={1,5,3,4,5,2,7,8};
int[] array2=new int[4];
int place=0;
int temp = 0;
for (int i = 0; i<array.length; i++)
        if(array[i]==2){ place =i; break; }

for (int i = place;i<array.length-1;i++) {
    temp = i;
    array[i]=array[++temp];
    }
    array2 = new int[array.length-1];
for(int i = 0;i<array2.length;i++){
    array2[i]=array[i];
}

        for (int i=0;i<array.length;i++) {
            System.out.println(array[i]);

        }
    }
}
class Tssst{

    public static void main(String[] args) {
        int[] x = {1,3,4,5,6};

    }
}