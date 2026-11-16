class Solution {
    public int longestConsecutive(int[] nums) {
        int l = nums.length;
        if(l==0) return 0; //edge case
        Set<Integer> map = new HashSet<>();
        for(int i=0;i<l;i++){
            map.add(nums[i]);
        }
        int res = 0;
        for (int num : map) {
            if (!map.contains(num - 1)) {
                int curr = num;
                int currentStreak = 1;
                while (map.contains(curr + 1)) {
                    curr++;
                    currentStreak++;
                }

                res = Math.max(res, currentStreak);
            }
        }

        return res;
    }
}