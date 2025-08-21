import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
        int i = 0, j = 0;
        
        while (j < n) {
            // Step 1: maintain window size <= k
            if (Math.abs(i - j) > k) {
                set.remove(nums[i]);
                i++; // shrink from left
            }
            
            // If nums[j] already exists in the set → duplicate found
            if (set.contains(nums[j])) {
                return true;
            }
            
            set.add(nums[j]);
            j++;
        }
        
        return false;
    }
}
