import java.util.*;

class Solution {

    // Helper function to check if all counts are zero
    private boolean allZero(int[] counter) {
        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }

    public int search(String pat, String txt) {
        int n = txt.length();
        int[] counter = new int[26];

        // Count frequency of characters in pattern
        for (int i = 0; i < pat.length(); i++) {
            char ch = pat.charAt(i);
            counter[ch - 'a']++;
        }

        int i = 0, j = 0;
        int result = 0;
        int k = pat.length();

        while (j < n) {
            counter[txt.charAt(j) - 'a']--;

            if (j - i + 1 == k) {
                if (allZero(counter)) {
                    result++;
                }
                counter[txt.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return result;
    }

    // Example test
    public static void main(String[] args) {
        Solution sol = new Solution();
        String pat = "for";
        String txt = "forxxorfxdofr";
        System.out.println(sol.search(pat, txt));  // Output: 3
    }
}
