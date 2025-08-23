class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        int prefixSum = 0, prevRemainder = 0;
        
        for (int i = 0; i < nums.length; i++) {   
            prefixSum = prefixSum + nums[i];
            int remainder = prefixSum % k;
            if (seen.contains(remainder)) return true;
            seen.add(prevRemainder);
            prevRemainder = remainder;
        }
        return false;
    }
}


// Another Way But Time Complex issue

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum % k == 0) return true;
            }
        }
        return false;
    }
}
