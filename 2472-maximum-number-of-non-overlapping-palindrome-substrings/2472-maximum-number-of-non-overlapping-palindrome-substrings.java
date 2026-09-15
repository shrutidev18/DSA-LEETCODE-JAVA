class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i < 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            for (int j = i + k - 1; j < n; j++) {
                if (pal[i][j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}