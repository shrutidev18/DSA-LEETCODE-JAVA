class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };
        
        int pathLength = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                
                for (int[] dir : directions) {
                    int nextRow = row + dir[0];
                    int nextCol = col + dir[1];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0) {
                        if (nextRow == n - 1 && nextCol == n - 1) {
                            return pathLength;
                        }
                        
                        queue.offer(new int[]{nextRow, nextCol});
                        grid[nextRow][nextCol] = 1;
                    }
                }
            }
        }
        
        return -1;
    }
}
