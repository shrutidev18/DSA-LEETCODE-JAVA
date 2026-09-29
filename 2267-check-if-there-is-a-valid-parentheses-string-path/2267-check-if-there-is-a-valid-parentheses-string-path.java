class Solution {
    private boolean[][][] vis;
    private char[][] grid;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        vis = new boolean[m][n][(m + n) / 2 + 1];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int k) {
        k += (grid[i][j] == '(') ? 1 : -1;
        if (k < 0 || k > (m - i + n - 1 - j)) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return k == 0;
        }
        if (vis[i][j][k]) {
            return false;
        }
        vis[i][j][k] = true;
        if (i + 1 < m && dfs(i + 1, j, k)) {
            return true;
        }
        if (j + 1 < n && dfs(i, j + 1, k)) {
            return true;
        }
        
        return false;
    }
}
