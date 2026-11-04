class Solution {
    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    int lowSize, highSize;
    long lowSum, highSum;

    void add(int num) {
        if (low.isEmpty() || num <= low.lastKey()) {
            low.merge(num, 1, Integer::sum);
            lowSize++;
            lowSum += num;
        } else {
            high.merge(num, 1, Integer::sum);
            highSize++;
            highSum += num;
        }
        balance();
    }

    void remove(int num) {
        if (low.containsKey(num)) {
            low.compute(num, (a, b) -> b == 1 ? null : b - 1);
            lowSize--;
            lowSum -= num;
        } else {
            high.compute(num, (a, b) -> b == 1 ? null : b - 1);
            highSize--;
            highSum -= num;
        }
        balance();
    }

    void balance() {
        int target = (lowSize + highSize + 1) / 2;

        while (lowSize > target) {
            int num = low.lastKey();

            low.compute(num, (a, b) -> b == 1 ? null : b - 1);
            lowSize--;
            lowSum -= num;

            high.merge(num, 1, Integer::sum);
            highSize++;
            highSum += num;
        }

        while (lowSize < target && highSize > 0) {
            int num = high.firstKey();

            high.compute(num, (a, b) -> b == 1 ? null : b - 1);
            highSize--;
            highSum -= num;

            low.merge(num, 1, Integer::sum);
            lowSize++;
            lowSum += num;
        }
    }

    long getCost() {
        long median = low.lastKey();

        return median * lowSize - lowSum
                + highSum - median * highSize;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        int m = n - x + 1;

        long[] cost = new long[m];

        low.clear();
        high.clear();
        lowSize = highSize = 0;
        lowSum = highSum = 0;

        for (int i = 0; i < x; i++) {
            add(nums[i]);
        }

        cost[0] = getCost();

        for (int i = x; i < n; i++) {
            remove(nums[i - x]);
            add(nums[i]);

            cost[i - x + 1] = getCost();
        }

        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j] == INF) {
                    continue;
                }

                if (i < n) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                }

                if (j < k && i + x <= n) {
                    dp[i + x][j + 1] = Math.min(
                        dp[i + x][j + 1],
                        dp[i][j] + cost[i]
                    );
                }
            }
        }

        return dp[n][k];
    }
}