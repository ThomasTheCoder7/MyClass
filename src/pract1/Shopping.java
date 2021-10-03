package pract1;

import java.util.Scanner;

public class Shopping {
    static Scanner scan = new Scanner(System.in);
    static String Itemname = "";
    static double Itemprice = 0;
    static int quantity = 0;

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("**********Welcome to UQU shopping program**********");
        while (true) {
            System.out.print("Please enter the name of the item that you want to buy:");
            Itemname = InputName();
           // System.out.println("");
            System.out.print("Please enter the price of the " + Itemname + ":");
            //System.out.println("");
            Itemprice = InputPrice();
            System.out.print("Please Enter the quantity:");
           // System.out.println("");
            quantity = InputQuantity();
            cart.addToCart(Itemname, Itemprice, quantity);
            System.out.println(cart);
            Itemname="";
            System.out.println("");
            System.out.print("Do you want to add another item?(y/n):");
            String statement = "";
            statement = scan.nextLine();
            while (!statement.equals("y") && !statement.equals("n")) {
                statement = scan.nextLine();

                if(!statement.equals("y") && !statement.equals("n")){
                System.out.println("Wrong input");
                System.out.print("please enter \"y\" or \"n\" :");}

            }
            if (statement.equals("n")) { break; }

        }

            System.out.println("Please Pay "+cart.getTotalPrice());
}


    public static String InputName(){
        String itemname="t";
        itemname=scan.nextLine();
        while(itemname.isBlank()){
                System.out.print("Wrong name.\n");
                System.out.print("Please enter the name of the item that you want to buy:");
            itemname=scan.nextLine();
        }
        return itemname;
    }

    public static double InputPrice(){
        double price;
        price = scan.nextDouble();
        while(true){
            if(price<=0){
                System.out.println("Quantity cannot be less than or equal zero.");
                System.out.print("Please Enter the price of the "+Itemname+":");
                price=scan.nextDouble();
            }else{break;}
        }
        return price;
    }

    public static int InputQuantity(){
        int quantity;
        quantity=scan.nextInt();
        while(true){
            if(quantity<=0){
                System.out.println("Quantity cannot be less than or equal zero.");
                System.out.print("Please Enter the quantity:");
                quantity=scan.nextInt();
            }else{break;}
        }
   return quantity; }
}
