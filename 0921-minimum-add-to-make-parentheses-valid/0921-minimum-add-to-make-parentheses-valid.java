class Solution {
    public int minAddToMakeValid(String s) {
        int openNeeded = 0;
        int closeNeeded = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                openNeeded++;
            } else {
                if (openNeeded > 0) {
                    openNeeded--;
                } else {
                    closeNeeded++;
                }
            }
        }
        return openNeeded + closeNeeded;
    }
}
