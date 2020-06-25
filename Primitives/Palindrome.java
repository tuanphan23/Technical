package Primitives;
/* 
A palindrome is a sequence that reads the same forwards and backward.
Given an integer as input, write a function that tests if it is a palindrome.
*/

class Palindrome {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        double log = Math.log10(x);
        int totalDigits = (int) (Math.floor(log)) + 1;
        int mask = (int) Math.pow(10, totalDigits - 1);

        for (int i = 0; i < totalDigits / 2; i++) {
            int first = x / mask;
            int last = x % 10;
            if (first != last)
                return false;
            x %= mask;
            x /= 10;
            mask /= 100;
        }

        return true;
    }
}