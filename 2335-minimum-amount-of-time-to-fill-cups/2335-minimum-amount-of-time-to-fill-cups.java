class Solution {
    public int fillCups(int[] amount) {
        int max = Arrays.stream(amount).max().getAsInt();
        int sum = Arrays.stream(amount).sum();
        return Math.max(max, (sum + 1) / 2);
    }
}