class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            String s = Integer.toString(nums[i]);
            int sum=0;
            for(int j=0;j<s.length();j++){
                sum=sum+ Character.getNumericValue(s.charAt(j));
            }
            if(sum==i){
                return i;
            }
        }
        return -1;
    }
}