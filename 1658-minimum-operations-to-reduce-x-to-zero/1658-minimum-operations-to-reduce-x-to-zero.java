class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer, int[]> map = new HashMap<>();

        int sum = 0;
        map.put(0, new int[]{n, 0});

        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            map.put(sum, new int[]{i, n - i});
        }

        int ans = Integer.MAX_VALUE;
        int prefixSum = 0;

        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                prefixSum += nums[i - 1];
            }

            int required = x - prefixSum;

            if (map.containsKey(required)) {
                int[] suffix = map.get(required);
                int suffixStart = suffix[0];
                int suffixLength = suffix[1];

                if (suffixStart >= i) {
                    ans = Math.min(ans, i + suffixLength);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}