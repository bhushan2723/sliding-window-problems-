import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] map = new int[128]; // frequency map for characters
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int requiredCount = t.length();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (map[rChar] > 0) { 
                requiredCount--;
            }
            map[rChar]--; // reduce count for window
            right++;

            // try to shrink the window
            while (requiredCount == 0) {
                if (minLen > right - left) {
                    minLen = right - left;
                    start = left;
                }

                char lChar = s.charAt(left);
                map[lChar]++;
                if (map[lChar] > 0) {
                    requiredCount++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
