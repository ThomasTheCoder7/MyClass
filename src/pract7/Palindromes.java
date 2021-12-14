package pract7;

public class Palindromes {
    public static void main(String[] args) {
        System.out.println(Palindrome("ppy"));
    }


    public static boolean Palindrome(String s){

        if(s.length()>=2&&s.charAt(0)==s.charAt(s.length()-1)){return Palindrome(s.substring(1,s.length()-1));}
        if(s.length()<2){return true;}
        return false;

    }
}
