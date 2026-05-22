class Solution {
    int perimeter=0;
    public int islandPerimeter(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    DFS(grid,i,j);
                   

                }
            }
        }
        return perimeter;
        
    }
    public void DFS(int grid[][],int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0 ){
           perimeter++;
           return;
        }
        if(grid[i][j]==-1){
            return;
        }
        grid[i][j]=-1;

        DFS(grid,i,j+1);
        DFS(grid,i+1,j);
        DFS(grid,i,j-1);
        DFS(grid,i-1,j);


    }
}