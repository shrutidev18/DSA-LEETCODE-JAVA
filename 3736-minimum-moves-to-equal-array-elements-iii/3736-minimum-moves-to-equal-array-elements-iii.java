class Solution {
    public int minMoves(int[] nums) {
        int l = nums.length;
        Arrays.sort(nums);
        int m=0;
        int max = nums[l-1];
        for(int i= l-2;i>=0;i--){
            m=m+max-nums[i];
        }
        return m;
    }
}