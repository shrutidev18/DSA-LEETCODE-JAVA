class Solution {
    public int maxDepth(String s) {
        int l=s.length();
        int c=0;
        int res =0;
        for(int i=0;i<l;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                c++;
            }
            else if(ch == ')'){
                res = Math.max(res,c);
                c--;
            }
        }
        return res;
    }
}