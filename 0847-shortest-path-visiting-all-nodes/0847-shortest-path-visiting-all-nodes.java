class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) {
            return 0;
        }
        int targetMask = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            int initialMask = 1 << i;
            queue.offer(new int[]{i, initialMask});
            visited[i][initialMask] = true;
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int mask = curr[1];
                if (mask == targetMask) {
                    return steps;
                }
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    
                    if (!visited[neighbor][nextMask]) {
                        visited[neighbor][nextMask] = true;
                        queue.offer(new int[]{neighbor, nextMask});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
