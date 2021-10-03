import java.util.Arrays;

public class Main{


    public static void main(String[] args) {
        int [] x = {1,2,3,4};

        int[] y = {1,2,3,4};
        i(x);
        i(y[0]);

        System.out.println(x[0]+" "+y[0]);

    }

    public static void i(int[] u){
        for(int i = 0;i<u.length;i++){
            u[i]++;
        }
    }

    public static void i(int y){
        y++;
    }

}
