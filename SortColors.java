class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int i = 0;       // pointer for 0
        int j = 0;       // pointer for current
        int k = n - 1;   // pointer for 2

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                // swap nums[j] and nums[k]
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            } else { // nums[j] == 0
                // swap nums[j] and nums[i]
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }
}
