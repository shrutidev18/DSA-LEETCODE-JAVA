class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if ((long) num * 9 < sum) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        while (sum >= 9 && sb.length() < num) {
            sb.append('9');
            sum -= 9;
        }
        if (sum > 0 && sb.length() < num) {
            sb.append((char) ('0' + sum));
            sum = 0;
        }
        while (sb.length() < num) {
            sb.append('0');
        }
        
        return sb.toString();
    }
}
