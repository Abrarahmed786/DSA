// Given an integer x, return true if x is a palindrome, and false otherwise.

class Solution {
    public boolean isPalindrome(int x) {
          if (x < 0) {
            return false;
        }

        String numberString = String.valueOf(x);
        int left = 0;
        int right = numberString.length() - 1;

        while (left < right) {
            if (numberString.charAt(left) != numberString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}