class Solution {
    int m,n;
    int directions[][]={{-1,0},{0,1},{1,0},{0,-1}};
    public int countIslands(int[][] grid, int k) {
        int count=0;
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long sum=DFS(grid,i,j);
                    if(sum%k==0){
                        count++;
                    }
}
            }
        }
        return count;
        
    }
    public long DFS(int grid[][],int i,int j){
        long sum=grid[i][j];
        grid[i][j]=0;
        
        for(int dir[]:directions){
            int x=dir[0]+i;
            int y=dir[1]+j;
            if(x>=0 && y>=0 && x<m && y<n && grid[x][y]>0){
                sum+=DFS(grid,x,y);
            }

        }
        return sum;



    }
}