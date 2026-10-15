class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int res =0;
        int vis[]=new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for(int j=0;j<n;j++){
            if(vis[j]==1) continue;
            q.add(j);
            vis[j]=1;
            res++;
            while(!q.isEmpty()){
                int cur = q.peek();
                for(int i=0;i<n;i++){
                    if(i==cur) continue;
                    int x = isConnected[cur][i];
                    if(x==1){
                        if(vis[i] != 1){
                        q.add(i);
                        vis[i]=1;
                        }
                    }

                }
                q.poll();
            }
    }
    return res;

    }
}