package pract1;

import java.util.Scanner;

public class TestPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size=0;
        try {
            System.out.print("set the size of your Database:");
            size = scanner.nextInt();
        }catch (Exception e){ System.out.println(e); }
        Person[] people = getInput(size);
        AskForSort(people);
        PrintDB(people);

    }

    static void PrintDB(Person[] people){
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }

    static void AskForSort(Person[] people) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to sort your Database? (yes/no):");
        String sortchoice="";
        try {
            sortchoice = scanner.next();
        } catch (Exception e){ System.out.println(e); }

        if(sortchoice.equals("yes")){
            System.out.println("How would you like to sort it?\nAlphabetically = 0\nBy Age = 1");
            try {
                System.out.print("Please make your choice:");
                switch (scanner.nextInt()) {
                    case 0:
                        Person.SortAlphabetically(people);
                        break;
                    case 1:
                        Person.SortByAge(people);
                        break;
                }
            }catch (Exception e){ System.out.println(e);} }

    }

    static Person[] getInput(int Size){
        Scanner scanner = new Scanner(System.in);
        Person[] people = new Person[Size];
        String name="";
        int age = 0;
        double height = 0.0;
        for(int i = 0;i<Size;i++){
            try{
                System.out.print("Name:");
                name = scanner.next();
                System.out.println("");
                System.out.print("Age:");
                age=scanner.nextInt();
                System.out.println("");
                System.out.print("Height: ");
                height = scanner.nextDouble();

            } catch (Exception e){ System.out.println(e); }
            people[i] = new Person(name,age,height);
            System.out.println("************************");
        }
        return people; }
}

