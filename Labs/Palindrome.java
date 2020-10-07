package Labs;

import java.util.ArrayList;
import java.util.Collections;
// Палиндром
public class Palindrome {
    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if(isPalindrome(s)){
                System.out.println(s+"="+isPalindrome(s));
            }
            else {
                System.out.println(s+"="+isPalindrome(s));
            }
        }

    }
    // Метод для обратной записи слова
    public static String reverseString(String strings){
        String reverse="";
        for (int i = strings.length()-1; i>-1; i--) {
         reverse+=strings.charAt(i);
        }
        return reverse;
    }
    // Метод для выявления палендрома
    public static boolean isPalindrome(String s){
        return (s.equals(reverseString(s)));
    }

}
