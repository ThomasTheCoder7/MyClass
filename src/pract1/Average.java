package pract1;

public class Average {
    public static void main(String[] args) {
        int s = 0;
        System.out.println("****************************");
        for(int i = 0;i< args.length;i++){
            System.out.println("Argument No."+i+": "+args[i]);
            s+=Integer.parseInt(args[i]);
        }
        System.out.println("****************************");
        System.out.println("The Average is: "+s/ args.length);
    }
}
