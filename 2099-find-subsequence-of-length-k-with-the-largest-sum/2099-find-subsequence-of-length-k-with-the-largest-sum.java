class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        java.util.Arrays.setAll(idx, i -> i);
        java.util.Arrays.sort(idx, (i, j) -> Integer.compare(nums[j], nums[i]));
        java.util.Arrays.sort(idx, 0, k, (i, j) -> Integer.compare(i, j));
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = nums[idx[i]];
        }
        return ans;
    }
}
