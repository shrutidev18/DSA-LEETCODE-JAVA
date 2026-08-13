class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        for (int j = 1; j <= n; j++) {
            dp[j] = Integer.MAX_VALUE;

            for (int i = Math.max(0, j - 3); i < j; i++) {
                int jump = j - i;
                int cost = costs[j - 1] + jump * jump;

                dp[j] = Math.min(dp[j], dp[i] + cost);
            }
        }

        return dp[n];
    }
}