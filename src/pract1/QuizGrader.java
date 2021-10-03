package pract1;

import java.util.Scanner;

public class QuizGrader {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean restart = true;
        while(restart){
            BeginQuiz();
                System.out.print("Grade another quiz? (y/n):");
               while(true){
                   String input = scan.next();
                   if(input.equals("y")){ restart = true; break;}
                   if(input.equals("n")){ restart = false; break;}
                   else {
                       System.out.print("Wrong input please type \"y\" or \"n\":");
                   }
               }


        }
        System.out.println("Thanks for using our Quiz Grading Tool!");


    }

    static void BeginQuiz(){
        double CorrectAnswers=0;
        Scanner scan = new Scanner(System.in);
        System.out.print("How many questions do you want in your quiz:");
        int Questions = Integer.parseInt(scan.nextLine());
        int[] Keys = new int[Questions];
        System.out.print("Enter the keys of your quiz in a single line:");
        String[] keys = scan.nextLine().split(" ");
        for(int i = 0;i<Questions;i++)
            Keys[i] = Integer.parseInt(keys[i]);

        System.out.print("Answer the questions in a single line: ");
        for(int i = 0; i < Questions; i++){
            if(Keys[i]==scan.nextInt()){
                CorrectAnswers++;
            }
        }

        double Percentage = (CorrectAnswers/Questions)*100;
        System.out.println("Your percentage is:"+Percentage);

    }
}
