class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int v[][]=new int[m][n];

        int area =0;
        //we traverse each cell 1 and apply dfs to those not visited
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(v[i][j] != 1 && grid[i][j] == 1){
                    area = Math.max(dfs(grid,i,j,v,0),area);
                }
            }
        }
        return area;
    }
    int dfs(int[][] grid , int i, int j, int[][] v,int a){
        v[i][j]=1;
        a++;
        if(j>0 && grid[i][j-1] == 1 && v[i][j-1] != 1){ 
            a = dfs(grid,i,j-1,v,a);
            }
        if(i>0 && grid[i-1][j] == 1 && v[i-1][j] != 1) { 
            a = dfs(grid,i-1,j,v,a);
        }
        if(j<grid[0].length-1 && grid[i][j+1] == 1 && v[i][j+1] != 1 ){
             a = dfs(grid,i,j+1,v,a);
        }
        if(i<grid.length-1 && grid[i+1][j] == 1 && v[i+1][j] != 1 ){
             a = dfs(grid,i+1,j,v,a);
        }
        return a;
    }
}