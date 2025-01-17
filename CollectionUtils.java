/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author: Charles
 */

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class CollectionUtils {
    public static <T> int countMatchingElements(Collection<T> collection, Predicate<T> condition) {
        int count = 0;
        for (T element : collection) {
            if (condition.test(element)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example: Counting odd numbers
        Collection<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int oddCount = countMatchingElements(numbers, n -> n % 2 != 0);
        System.out.println("Odd count: " + oddCount); // Output: 5

        // Example: Counting prime numbers
        int primeCount = countMatchingElements(numbers, CollectionUtils::isPrime);
        System.out.println("Prime count: " + primeCount); // Output: 4 (2, 3, 5, 7)

        // Example: Counting palindromes
        Collection<String> words = List.of("madam", "racecar", "hello", "level", "world");
        int palindromeCount = countMatchingElements(words, CollectionUtils::isPalindrome);
        System.out.println("Palindrome count: " + palindromeCount); // Output: 3
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Helper method to check if a string is a palindrome
    private static boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
