// Given a string s consisting of only the characters 'a' and 'b', return true if every 'a' appears before every 'b' in the string. Otherwise, return false.

class Solution {
  bool checkString(String s) {
    bool foundB = false;
    for (int i = 0; i < s.length; i++) {
      if (s[i] == 'b') {
        foundB = true;
      } else if (s[i] == 'a' && foundB) {
        return false;
      }
    }
    return true;
  }
}
