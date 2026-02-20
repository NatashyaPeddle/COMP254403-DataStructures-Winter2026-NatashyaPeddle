import java.util.Scanner;

public class NATASHYAPEDDLE_LAB3_Exercise2 {

    /*Write a short recursive Java method that determines if a string s is a palindrome, that is, it is equal to its
    reverse. Examples of palindromes include 'racecar' and 'gohangasalamiimalasagnahog'. Test the method by asking the
     user to provide string entries to be checked. Hint: Check the equality of the first and last characters and recur
      (but be careful to return the correct value for both odd and even-length strings).
     */

public static boolean palindromeFinder(String s, int left, int right){
    /// string param, int left & right
    /// left = first character checked
    /// right = last character checked

if (s.length() == 1) return true; ///if only 1 letter = palindrome

if (left >= right) return true; /// checking if left is greater/equal to right it means that we've gone through enough letters to confirm if Palindrome
    /// Checking each letter like connected train cars

if (s.charAt(left) != s.charAt(right)) return false; ///if last and first arent the same then its not a palindrome


return (palindromeFinder(s, left + 1, right - 1)); ///moves inward by 1 on both ends - checking the next ones (like a line of connected train cars)

}

public static boolean isPalindrome(String s){ /// starts recursive check
    return palindromeFinder(s,0,s.length()-1);
}


    /// MAIN---------------------------------------------------------------------------------

    public static void main(String[] args) {

    Scanner input = new Scanner(System.in); ///creates scanner object to take user input


    System.out.println("Enter a string to check if palindrome:");
    String s = input.nextLine(); ///takes user input stores it as string s

    if(isPalindrome(s)) { /// confirms whether its palindrome or not by calling ispalindrome method
        System.out.println("Palindrome confirmed.");
    }else {
        System.out.println("Not Palindrome.");
    }

        input.close(); ///closes the scanner/input to save resources
    }

}
