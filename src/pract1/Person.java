package pract1;

import java.util.Scanner;

/**
 * Class PRACT1.Person.java
 * A simple class which provides an definitionn of a PRACT1.Person object
 *
 * @author Nour
 */

public class Person {
    private String name;
    private int age;
    private double height;

    /**
     * Default constructor creates an empty instance of a PRACT1.Person
     */
    public Person() {
        name = "";
        age = 0;
    }

    /**
     * Alternative Constructor which creates and initialises a
     * PRACT1.Person using the supplied parameters
     *
     * @param nName used to set the PRACT1.Person name
     * @param nAge used to set the PRACT1.Person age
     * @param nHeight  used to se the PRACT1.Person height
     */
    public Person(String nName, int nAge,double nHeight) {
        name = nName;
        age = nAge;
        height = nHeight;
    }
    /**
     * Retrieve the name of the PRACT1.Person
     *
     * @return the PRACT1.Person name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieve the age of the PRACT1.Person
     *
     * @return the PRACT1.Person age
     */
    public int getAge() {
        return age;
    }

    /**
     * Update the name of the PRACT1.Person
     *
     * @param nName the new PRACT1.Person name
     */
    public void setName(String nName) {
        name = nName;
    }

    /**
     * Update the age of the PRACT1.Person
     *
     * @param nAge the new PRACT1.Person age
     */
    public void setAge(int nAge) {
        age = nAge;
    }

    public double getHeight() {
        return height;
    }
    /**
     * Update the age of the PRACT1.Person
     *
     * @param nHeight  the new PRACT1.Person Height
     */
    public void setHeight(double nHeight) {
        this.height = height;
    }

    public static void SortAlphabetically(Person[] people){
        Person tempo;
        for (int i =0;i<people.length;i++){
            for (int x = 0;x<people.length;x++){
                if(people[i].getName().compareTo(people[x].getName())<0){
                    tempo = people[x];
                    people[x] = people[i];
                    people[i] = tempo;
                }
            }
        }
    }
    public static void SortByAge(Person[] people){
        Scanner scanner = new Scanner(System.in);
        Person tempo;
        System.out.println("Sort from oldest to youngest: 0\nSort from youngest to oldest: 1");
        System.out.print("Enter your input: ");
        switch (scanner.nextInt()){
            case 0:
                for (int i =0;i<people.length;i++){
                    for (int x = 0;x<people.length;x++){
                        if(people[i].getAge()>people[x].getAge()){
                            tempo = people[x];
                            people[x] = people[i];
                            people[i] = tempo;
                        }
                    }
                }
                break;
            case 1:
                for (int i =0;i<people.length;i++){
                    for (int x = 0;x<people.length;x++){
                        if(people[i].getAge()<people[x].getAge()){
                            tempo = people[x];
                            people[x] = people[i];
                            people[i] = tempo;
                        }
                    }
                }
                break;
        }

    }
    /**
     * Returns a string representation of the object. In general, the
     * 'toString' method returns a string that "textually represents" this
     * object. The result should be a concise but informative representation
     * that is easy for a person to read. It is recommended that all Objects
     * provide this method.
     *
     * @return String representation of an object
     */
    public String toString() {
        return "PRACT1.Person(" + name + ", " + age + ", " + height + ")";
    }
    // ANSWER OF Q1
    public static void main(String[] args) {
        Person person = new Person("mohammed",11,187.9);
        System.out.println(person);
    }

}
