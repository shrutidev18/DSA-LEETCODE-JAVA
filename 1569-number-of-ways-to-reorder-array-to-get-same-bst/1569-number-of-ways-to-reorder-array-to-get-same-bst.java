class Solution {
    private final int MOD = 1_000_000_007;
    private long[][] C;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        C = new long[n][n];
        for (int i = 0; i < n; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        return (int) (dfs(list) - 1 + MOD) % MOD;
    }

    private long dfs(List<Integer> list) {
        if (list.size() <= 2) {
            return 1;
        }

        long root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < root) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        long leftWays = dfs(left);
        long rightWays = dfs(right);

        int leftSize = left.size();
        int rightSize = right.size();
        long ways = C[leftSize + rightSize][leftSize];
        ways = (ways * leftWays) % MOD;
        ways = (ways * rightWays) % MOD;

        return ways;
    }
}
