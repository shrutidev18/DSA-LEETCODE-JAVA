class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(); //number of rooms
        int vis[]=new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        vis[0]=1;
        while(!q.isEmpty()){
            int r = q.peek();
            for(int i=0;i<rooms.get(r).size();i++){
                int nx = rooms.get(r).get(i);
                if(r==nx) continue;
                if(vis[nx]!=1){
                    q.add(nx);
                    vis[nx]=1;
                }
            }
            q.poll();
        }
        for(int x:vis){
            if(x==0) return false;
        }
        return true;
    }
}