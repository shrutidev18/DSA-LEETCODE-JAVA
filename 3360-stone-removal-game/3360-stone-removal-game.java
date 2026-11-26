class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        int t = 0; //alice - 0, bob - 1
        int r = 10;
        while(n!=0){
            if(n>=r){
                n=n-r;
                r--;
                t= t==0?1:0;
            }
            else{
                if(t==0) return false;
                else return true;
            }
        }
        if(t==1) return true;
        else return false;

    }
}