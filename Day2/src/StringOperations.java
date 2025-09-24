import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take string input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String lowerInput = input.toLowerCase(); // convert to lowercase for easy comparison

        // Step 2: Reverse the string using StringBuilder
        StringBuilder sb = new StringBuilder(input);
        String reversed = sb.reverse().toString();

        // Step 3: Count vowels and consonants
        int vowels = 0, consonants = 0;
        for (int i = 0; i < lowerInput.length(); i++) {
            char ch = lowerInput.charAt(i);
            if (ch >= 'a' && ch <= 'z') { // consider only alphabets
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        // Step 4: Check for palindrome
        boolean isPalindrome = input.equalsIgnoreCase(reversed);

        // Step 5: Print results
        System.out.println("\nOriginal String: " + input);
        System.out.println("Reversed String: " + reversed);
        System.out.println("Number of vowels: " + vowels);
        System.out.println("Number of consonants: " + consonants);
        if (isPalindrome) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}
