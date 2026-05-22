class Solution {
    int island=0;
    public int numIslands(char[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    DFS(grid,i,j);
                    island++;
                   
                }
            }
        }
        return island;
        
    }
    public void DFS(char grid[][],int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0' ||grid[i][j]=='@'){
            return;
        }
        

        grid[i][j]='@';

        DFS(grid,i,j+1);
        DFS(grid,i+1,j);
        DFS(grid,i,j-1);
        DFS(grid,i-1,j);

    }
}