package pract1;

import java.util.Scanner;

public class IntegerListTest
{
    static IntegerList list = new IntegerList(10); static Scanner scan = new Scanner(System.in);

    //-------------------------------------------------------
// Create a list, then repeatedly print the menu and do what the
// user asks until they quit
//-------------------------------------------------------
    public static void main(String[] args)
    {
        //list.addElement(5);
        printMenu();
        int choice = scan.nextInt();

        while (choice != 0) {
            dispatch(choice); printMenu();
            choice = scan.nextInt();
        }

    }

    //-------------------------------------
// Do what the menu item calls for
//-------------------------------------
    public static void dispatch(int choice)
    {




        int loc; switch(choice) {
        case 0:
            System.out.println("Bye! ") ; break;
        case 1:
            System.out.println("How big should the list be?");
            int size = scan.nextInt();
            while (size<1){
                System.out.println("Wrong input,You cannot have an array size less than 1.");
                System.out.println("How big should the list be?");
                size=scan.nextInt();
            }
            list = new IntegerList(size); list.randomize();
            break;

        case 10:
            System.out.println(list.Capacity);
            System.out.print("Enter the new size of your list:"); int temp = scan.nextInt();
            while(temp<list.Size){
                if(temp>0)System.out.println("Wrong input,You cannot decrease size");
                if(temp<0)System.out.println("Wrong input,You cannot have array size less than 0");
                temp = scan.nextInt();
            }
            list.Capacity = temp;
            list.IncreaseSize();
            System.out.println(list.Capacity);
            break;

        case 2:
            System.out.print("Enter the int you want to add in the list:");
            list.addElement(scan.nextInt());
            System.out.println("int Added!");
            break;
        case 3:
            System.out.print("Enter the int you want to remove from the list:");
            if(list.RemoveFirst(scan.nextInt()))
                System.out.println("Removed");
            break;
        case 4:
            System.out.println("Enter the int you want to remove from the list:");
            list.RemoveAll(scan.nextInt());
            break;
        case 5:
            list.print(); break;
        default:
            System.out.println("Sorry, invalid choice");
    }
    }

    //----------------------------
// Print the user's choices
//----------------------------
    public static void printMenu()
    {

        System.out.println("\n Menu	"); System.out.println("	====");
        System.out.println("0: Quit");
        System.out.println("1: Create a new list (** do this first!! **)");
        System.out.println("2: Add element");
        System.out.println("3:Remove one specified element from the list");
        System.out.println("4:Remove all specified element from the list");
        System.out.println("5: Print the list");

        System.out.print("\nEnter your choice: ");
    }


}
