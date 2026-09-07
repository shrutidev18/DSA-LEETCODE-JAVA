class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        long mod = 1000000007;

        long[] dp = new long[n + 1];
        long[] track = new long[26];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int x = s.charAt(i - 1) - 'a';

            dp[i] = (2L * dp[i - 1] - track[x] + mod) % mod;
            track[x] = dp[i - 1];
        }

        return (int)((dp[n] - 1 + mod) % mod);
    }
}