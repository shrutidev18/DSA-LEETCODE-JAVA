class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isPositive = (dividend > 0 == divisor > 0);
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        int quotient = 0;
        while (a <= b) {
            int currentDivisor = b;
            int currentQuotient = 1;
            while (currentDivisor >= (Integer.MIN_VALUE >> 1) && a <= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                currentQuotient <<= 1;
            }
            a -= currentDivisor;
            quotient += currentQuotient;
        }
        return isPositive ? quotient : -quotient;
    }
}
