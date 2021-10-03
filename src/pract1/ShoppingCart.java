package pract1;

import java.text.NumberFormat;


// ***************************************************************
// ShoppingCart.java
//
// Represents a shopping cart as an array of items
// ***************************************************************



public  class ShoppingCart
{
    private int itemCount;	      // total number of items in the cart
    private double totalPrice;   // total price of items in the cart
    private int capacity;       // current cart capacity
    private Item[] cart;


//
// Creates an empty shopping cart with a capacity of 5 items.
//

    public ShoppingCart()
    {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        cart=new Item[capacity];
    }


//
// Adds an item to the shopping cart.
//

    public void addToCart(String itemName, double price, int quantity) {
        if(capacity<=itemCount){ IncreaseSize(); }
        cart[itemCount]=new Item(itemName,price,quantity);
        itemCount++;
        totalPrice+=price*quantity;
    }

//
// Returns the contents of the cart together with
// summary information.




    //
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String contents = "\nShopping Cart\n";
        contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";

        for (int i = 0; i < itemCount; i++) contents += cart[i].toString() + "\n";

        contents += "\nTotal Price: " + fmt.format(totalPrice); contents += "\n";

        return contents;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    //
//	Increases the capacity of the shopping cart by 3
//
    private void IncreaseSize(){
        if (capacity<=cart.length){
            capacity=capacity+3;
        }
        Item[] tempArray = new Item[capacity];
        for(int i = 0;i< cart.length;i++){
            tempArray[i]=cart[i];
        }
        cart=tempArray;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addToCart("Milk",3.5,3);
        cart.addToCart("Carrot",2.2,10);
        cart.addToCart("Banana",10.5,3);
        cart.addToCart("Orange",5,3);
        cart.addToCart("Bread",0.5,10);
        // cart.addToCart("Soda",0.5,10);
        System.out.println(cart);
    }
}