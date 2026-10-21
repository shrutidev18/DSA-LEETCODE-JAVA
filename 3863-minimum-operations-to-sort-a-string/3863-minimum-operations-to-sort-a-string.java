class Solution {
    public int minOperations(String s) {
        int l = s.length();
        boolean sorted = true;
        for (int i = 0; i < l - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        if (l == 2) return -1;

        char minChar = 'z', maxChar = 'a';
        for (char c : s.toCharArray()) {
            minChar = (char) Math.min(minChar, c);
            maxChar = (char) Math.max(maxChar, c);
        }
        
        int firstMin = s.indexOf(minChar);
        int lastMax = s.lastIndexOf(maxChar);

        if (firstMin == 0 || lastMax == l - 1) {
            return 1;
        }

        if (firstMin == l - 1 && lastMax == 0) {
            long distinctCount = s.chars().distinct().count();
            return (distinctCount == 2) ? 2 : 3;
        }
        return 2;
    }
}