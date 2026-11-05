class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c=0;
        int dis;
        int t;
        for(int i=0;i<arr1.length;i++){
            t=0;
            for(int j=0;j<arr2.length;j++){
                dis = Math.abs(arr1[i]-arr2[j]);
                if(dis<=d){
                    t++; break;
                }

            }
            if(t==0) c=c+1;
        }
        return c;

    }
}