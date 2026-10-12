class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();

        if (totalSum < Math.abs(target) || (totalSum + target) % 2 != 0) {
            return 0;
        }
        
        int subsetTarget = (totalSum + target) / 2;
        return countSubsets(nums, subsetTarget);
    }
    
    private int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; 
        
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[target];
    }
}
