class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];
        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(squares);

        long smallerSum = 0;
        long largerSum = 0;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                smallerSum += squares[i];
            } else {
                largerSum += squares[i];
            }
        }
        return largerSum - smallerSum;
    }
}
