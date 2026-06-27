class Solution {
    public int orangesRotting(int[][] grid) {
        int directions[][]={{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]>q=new LinkedList<>();
        int freshcount=0;
        int minute=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});

                }else if(grid[i][j]==1){
                    freshcount++;

                }
            }
        }
        if(freshcount==0){
            return 0;
        }

        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int curr[]=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int check[]:directions){
                    int new_r=r+check[0];
                    int new_c=c+check[1];
                    if(new_r<=grid.length-1 && new_c<=grid[0].length-1 && new_r>=0 && new_c>=0 && grid[new_r][new_c]==1){
                        grid[new_r][new_c]=2;
                        freshcount--;
                        q.offer(new int[]{new_r,new_c});
                    }
                }

            }
            minute++;
        }
        return freshcount==0?minute-1:-1;
        
    }
}