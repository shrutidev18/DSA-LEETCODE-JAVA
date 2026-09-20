class Solution {
    public int reverseDegree(String s) {
        int l = s.length();
        int sum=0;
        for(int i=1;i<=l;i++){
            int asc = (int)s.charAt(i-1) - 97;
            int val = i* Math.abs(asc-26);
            sum=sum+val;
        }
        return sum;
    }
}