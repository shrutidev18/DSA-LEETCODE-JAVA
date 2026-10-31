class Solution {
    private static final int MOD = 1_000_000_007;
    private Integer[][][] memo;
    private int m, n;
    private int[][] grid;

    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.memo = new Integer[m][n][3];
        return dfs(0, 0, 2);
    }

    private int dfs(int r, int c, int dir) {
        if (r >= m || c >= n) {
            return 0; 
        }
        if (r == m - 1 && c == n - 1) {
            return 1; 
        }
        if (memo[r][c][dir] != null) {
            return memo[r][c][dir];
        }

        long totalPaths = 0;

        if (dir == 2) {
            totalPaths = (totalPaths + getNextPaths(r, c + 1, 0)) % MOD;
            totalPaths = (totalPaths + getNextPaths(r + 1, c, 1)) % MOD;
        } else if (dir == 0) { 
            if (grid[r][c] == 1) {
                totalPaths = (totalPaths + getNextPaths(r + 1, c, 1)) % MOD;
            } else {
                totalPaths = (totalPaths + getNextPaths(r, c + 1, 0)) % MOD;
                totalPaths = (totalPaths + getNextPaths(r + 1, c, 1)) % MOD;
            }
        } else {
            if (grid[r][c] == 1) {
                totalPaths = (totalPaths + getNextPaths(r, c + 1, 0)) % MOD;
            } else {
                totalPaths = (totalPaths + getNextPaths(r, c + 1, 0)) % MOD;
                totalPaths = (totalPaths + getNextPaths(r + 1, c, 1)) % MOD;
            }
        }

        return memo[r][c][dir] = (int) totalPaths;
    }

    private int getNextPaths(int nextR, int nextC, int nextDir) {
        return dfs(nextR, nextC, nextDir);
    }
}
