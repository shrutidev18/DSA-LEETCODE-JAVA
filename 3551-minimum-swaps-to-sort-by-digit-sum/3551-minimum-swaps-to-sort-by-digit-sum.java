class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = getDigitSum(nums[i]);
            arr[i][1] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        Map<Integer, Integer> targetIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetIndexMap.put(arr[i][1], i);
        }
        
        boolean[] visited = new boolean[n];
        int totalSwaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || targetIndexMap.get(nums[i]) == i) {
                continue;
            }
            
            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = targetIndexMap.get(nums[curr]);
                cycleSize++;
            }
            if (cycleSize > 1) {
                totalSwaps += (cycleSize - 1);
            }
        }
        
        return totalSwaps;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
