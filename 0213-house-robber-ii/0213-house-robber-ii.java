class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp1[]=new int[n+1];
        dp1[0]=0;dp1[1]=nums[0];
        for(int i=2;i<=n-1;i++){
            int yes = dp1[i-2]+nums[i-1];
            int no=dp1[i-1];
            dp1[i]=Math.max(yes,no);
        }
        int dp2[]=new int[n+1];
        dp2[0]=0;dp2[1]=0;dp2[2]=nums[1];
        for(int i=3;i<=n;i++){
            int yes = dp2[i-2]+nums[i-1];
            int no=dp2[i-1];
            dp2[i]=Math.max(yes,no);
        }
        return Math.max(dp1[n-1],dp2[n]);
    }
}