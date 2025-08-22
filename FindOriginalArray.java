import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        if (n % 2 != 0) {
            return new int[0];
        }

        Arrays.sort(changed);

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = changed[i];
            int twice = num * 2;

            if (freq.get(num) == 0) continue;

            if (freq.getOrDefault(twice, 0) == 0) {
                return new int[0];
            }

            result.add(num);

            freq.put(num, freq.get(num) - 1);
            freq.put(twice, freq.get(twice) - 1);
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
