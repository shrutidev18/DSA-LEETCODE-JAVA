class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<Integer>();
        int in=0;
        int low = nums[0];
        int high= nums[nums.length -1];
        int i= low;
        while(i<high){
            if(i== nums[in]){
                in++;
                i++;
            }
            else{
                while(i<nums[in]){
                    res.add(i);
                    i++;
                }
            }
        }
        return res;
    }
}