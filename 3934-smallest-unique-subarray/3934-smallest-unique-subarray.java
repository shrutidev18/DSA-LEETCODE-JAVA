class Solution {
    private static final long BASE1 = 1315423911L;
    private static final long BASE2 = 1000003L;
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;

    private int n;
    private long[] h1, h2, p1, p2;

    public int smallestUniqueSubarray(int[] nums) {
        this.n = nums.length;
        this.h1 = new long[n + 1];
        this.h2 = new long[n + 1];
        this.p1 = new long[n + 1];
        this.p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 0; i < n; i++) {
            long val = nums[i] + 1L;
            h1[i + 1] = (h1[i] * BASE1 + val) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + val) % MOD2;
            p1[i + 1] = (p1[i] * BASE1) % MOD1;
            p2[i + 1] = (p2[i] * BASE2) % MOD2;
        }

        int lo = 1, hi = n, ans = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUnique(mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUnique(int len) {
        Map<Long, Integer> freq = new HashMap<>();
        for (int i = 0; i + len <= n; i++) {
            long a = ((h1[i + len] - h1[i] * p1[len]) % MOD1 + MOD1) % MOD1;
            long b = ((h2[i + len] - h2[i] * p2[len]) % MOD2 + MOD2) % MOD2;
            long combined = (a << 32) ^ (b & 0xffffffffL);
            freq.merge(combined, 1, Integer::sum);
        }
        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}