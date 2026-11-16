class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder nextString = new StringBuilder();           
            for (int i = 0; i < s.length(); i += k) {
                int groupSum = 0;
                int end = Math.min(s.length(), i + k);               
                for (int j = i; j < end; j++) {
                    groupSum += s.charAt(j) - '0';
                }              
                nextString.append(groupSum);
            }           
            s = nextString.toString();
        }       
        return s;
    }
}
