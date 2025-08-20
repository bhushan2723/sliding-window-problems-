class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        k = p.length();
        List<Integer> result = new ArrayList<>();
        if (n < k) 
            return result;

        int[] counter = new int[26];
        for (char ch : p.toCharArray()) {
            counter[ch - 'a']++;
        }

        int i = 0, j = 0;
        while (j < n) {
            counter[s.charAt(j) - 'a']--;

            if (j - i + 1 == k) {
                if (allZero(counter)) {
                    result.add(i);
                }
                counter[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return result;
    }

    private boolean allZero(int[] counter) {
        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }
}
