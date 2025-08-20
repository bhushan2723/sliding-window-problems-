class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
  int n = nums.length;

        int i = 0, j = 0;
        int minL = Integer.MAX_VALUE;  // instead of n, we use MAX_VALUE
        int sum = 0;

        while (j < n) {
            sum += nums[j];

            // Shrink window while sum >= target
            while (sum >= target) {
                minL = Math.min(minL, j - i + 1);
                sum -= nums[i];
                i++; // move left pointer
            }
            j++;
        }

        return (minL == Integer.MAX_VALUE) ? 0 : minL;
    }

    // Example test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(sol.minSubArrayLen(target, nums)); // Output: 2
    }
}
