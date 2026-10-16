class Solution {
    private static final int MOD = 1000000007;
    private static class Node {
        long sum = 0;
        long sumOfSquares = 0;
        long lazy = 0;
    }

    private Node[] tree;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new Node[4 * n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSumOfSquares = 0;

        for (int r = 0; r < n; r++) {
            int l = lastSeen.getOrDefault(nums[r], -1) + 1;
            update(1, 0, n - 1, l, r, 1);
            
            lastSeen.put(nums[r], r);
            totalSumOfSquares = (totalSumOfSquares + tree[1].sumOfSquares) % MOD;
        }

        return (int) totalSumOfSquares;
    }

    private void pushDown(int node, int start, int end) {
        if (tree[node].lazy == 0) return;

        long val = tree[node].lazy;
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;
        long leftLen = mid - start + 1;
        tree[leftChild].sumOfSquares = (tree[leftChild].sumOfSquares 
                                        + 2 * val * tree[leftChild].sum 
                                        + val * val % MOD * leftLen) % MOD;
        tree[leftChild].sum = (tree[leftChild].sum + val * leftLen) % MOD;
        tree[leftChild].lazy = (tree[leftChild].lazy + val) % MOD;
        long rightLen = end - mid;
        tree[rightChild].sumOfSquares = (tree[rightChild].sumOfSquares 
                                         + 2 * val * tree[rightChild].sum 
                                         + val * val % MOD * rightLen) % MOD;
        tree[rightChild].sum = (tree[rightChild].sum + val * rightLen) % MOD;
        tree[rightChild].lazy = (tree[rightChild].lazy + val) % MOD;
        tree[node].lazy = 0;
    }

    private void update(int node, int start, int end, int l, int r, long val) {
        if (l <= start && end <= r) {
            long len = end - start + 1;
            tree[node].sumOfSquares = (tree[node].sumOfSquares 
                                        + 2 * val * tree[node].sum 
                                        + val * val % MOD * len) % MOD;
            tree[node].sum = (tree[node].sum + val * len) % MOD;
            tree[node].lazy = (tree[node].lazy + val) % MOD;
            return;
        }

        pushDown(node, start, end);
        int mid = start + (end - start) / 2;

        if (l <= mid) {
            update(2 * node, start, mid, l, r, val);
        }
        if (r > mid) {
            update(2 * node + 1, mid + 1, end, l, r, val);
        }

        tree[node].sumOfSquares = (tree[2 * node].sumOfSquares + tree[2 * node + 1].sumOfSquares) % MOD;
        tree[node].sum = (tree[2 * node].sum + tree[2 * node + 1].sum) % MOD;
    }
}
