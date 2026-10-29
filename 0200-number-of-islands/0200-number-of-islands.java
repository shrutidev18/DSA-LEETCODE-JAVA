class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        int c=0;
        int v[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(v[i][j] != 1 && grid[i][j] == '1'){
                    dfs(grid,i,j,v);
                    c++;
                }
            }
        }
        return c;
        
    }
    void dfs(char grid[][], int i,int j,int[][] v){
            v[i][j]=1;
            //left
            if(j>0 && v[i][j-1] != 1 && grid[i][j-1] == '1') dfs(grid,i,j-1,v);
            //top
            if(i>0 && v[i-1][j] != 1 && grid[i-1][j] == '1') dfs(grid,i-1,j,v);
            //right
            if(j<grid[0].length-1 && v[i][j+1] != 1 && grid[i][j+1] == '1') dfs(grid,i,j+1,v);
            //down
            if(i<grid.length-1 && v[i+1][j] != 1 && grid[i+1][j] == '1') dfs(grid,i+1,j,v);
    }
}