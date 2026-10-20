class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i * i != n) {
                    divisors.add(n / i);
                }
            }
        }
        
        int totalSum = 0;
        for (int k : divisors) {
            if (isValid(nums, n, k)) {
                totalSum += k;
            }
        }
        
        return totalSum;
    }
    
    private boolean isValid(int[] nums, int n, int k) {
        int previousMax = Integer.MIN_VALUE;
        for (int start = 0; start < n; start += k) {
            int end = start + k;
            int drops = 0;
            int dropIndex = -1;
            
            for (int i = 0; i < k; i++) {
                int currIdx = start + i;
                int nextIdx = start + (i + 1) % k;
                
                if (nums[currIdx] > nums[nextIdx]) {
                    drops++;
                    dropIndex = i;
                }
            }
            if (drops > 1) {
                return false;
            }
            int currentMin, currentMax;
            if (drops == 0) {
                currentMin = nums[start];
                currentMax = nums[end - 1];
            } else {
                int headIdx = start + (dropIndex + 1) % k;
                int tailIdx = start + dropIndex;
                currentMin = nums[headIdx];
                currentMax = nums[tailIdx];
            }
            if (currentMin < previousMax) {
                return false;
            }
            
            previousMax = currentMax;
        }
        
        return true;
    }
}
