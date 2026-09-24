class Solution {
    public int numIdenticalPairs(int[] nums) {
        int goodPairsCount = 0;
        int[] frequency = new int[101]; 
        
        for (int num : nums) {
            goodPairsCount += frequency[num];
            frequency[num]++;
        }
        
        return goodPairsCount;
    }
}
