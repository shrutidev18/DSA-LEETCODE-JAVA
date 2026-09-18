class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }
        java.util.Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        
        for (double[] worker : workers) {
            double ratio = worker[0];
            double q = worker[1];
            
            maxHeap.offer(q);
            totalQuality += q;
            
            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, totalQuality * ratio);
            }
        }
        
        return minCost;
    }
}
