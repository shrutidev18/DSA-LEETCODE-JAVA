class Solution {
    class Node {
        long prod;
        int[] remain;

        Node(int k) {
            remain = new int[k];
            prod = 1;
        }
    }

    class SegmentTree {
        private int n, k;
        private Node[] tree;
        private int[] nums;

        public SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.nums = nums;
            this.tree = new Node[4 * n];
            for (int i = 0; i < 4 * n; i++) {
                tree[i] = new Node(k);
            }
            build(0, 0, n - 1);
        }

        private Node merge(Node left, Node right) {
            Node res = new Node(k);
            res.prod = (left.prod * right.prod) % k;
            for (int i = 0; i < k; i++) {
                res.remain[i] = left.remain[i];
            }
            long leftProd = left.prod;
            for (int i = 0; i < k; i++) {
                int newRem = (int) ((leftProd * i) % k);
                res.remain[newRem] += right.remain[i];
            }
            return res;
        }

        private void build(int idx, int l, int r) {
            if (l == r) {
                tree[idx].prod = nums[l] % k;
                tree[idx].remain[nums[l] % k] = 1;
                return;
            }
            int mid = (l + r) / 2;
            build(2 * idx + 1, l, mid);
            build(2 * idx + 2, mid + 1, r);
            tree[idx] = merge(tree[2 * idx + 1], tree[2 * idx + 2]);
        }

        public void update(int idx, int l, int r, int pos, int val) {
            if (l == r) {
                nums[pos] = val;
                tree[idx].prod = val % k;
                for (int i = 0; i < k; i++) tree[idx].remain[i] = 0;
                tree[idx].remain[val % k] = 1;
                return;
            }
            int mid = (l + r) / 2;
            if (pos <= mid) update(2 * idx + 1, l, mid, pos, val);
            else update(2 * idx + 2, mid + 1, r, pos, val);
            tree[idx] = merge(tree[2 * idx + 1], tree[2 * idx + 2]);
        }

        public Node query(int idx, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return tree[idx];
            }
            int mid = (l + r) / 2;
            if (qr <= mid) return query(2 * idx + 1, l, mid, ql, qr);
            if (ql > mid) return query(2 * idx + 2, mid + 1, r, ql, qr);
            return merge(query(2 * idx + 1, l, mid, ql, mid), query(2 * idx + 2, mid + 1, r, mid + 1, qr));
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(nums, k);
        int m = queries.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            st.update(0, 0, n - 1, index, value);
            Node resNode = st.query(0, 0, n - 1, start, n - 1);
            ans[i] = resNode.remain[x % k];
        }

        return ans;
    }
}
