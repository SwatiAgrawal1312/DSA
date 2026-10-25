class Solution {
    int m,n;
    public int closedIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    if(DFS(grid,i,j)){
                        count++;

                    }
                }
            }
        }
        return count;
        
    }
    public boolean DFS(int grid[][],int i,int j){
        if(i<0 || j<0|| i>=m || j>=n ){
            return false;
        }
        if(grid[i][j]==1){
            return true;
        }
        grid[i][j]=1;

        boolean top=DFS(grid,i-1,j);
        boolean right=DFS(grid,i,j+1);
        boolean bottom=DFS(grid,i+1,j);
        boolean left=DFS(grid,i,j-1);
        return top && right && bottom && left;
    }
}