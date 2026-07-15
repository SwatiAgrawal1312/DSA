class Solution {
    int directions[][]={{0,1},{1,0},{0,-1},{-1,0}};
    
   
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int original=image[sr][sc];
        if(original==color){
            return image;
        }
        Queue<int[]> q=new LinkedList<>(); 
        q.offer(new int[]{sr,sc});
        image[sr][sc]=color;

        while(!q.isEmpty()){
            
                int curr[]=q.poll();
               for(int direction[]:directions){
                int new_row=direction[0]+curr[0];
                int new_col=direction[1]+curr[1];
                if(new_row>=0 && new_col>=0 && new_row<m && new_col<n && image[new_row][new_col]==original){
                    image[new_row][new_col]=color;
                    q.offer(new int[]{new_row,new_col});
                }

               
            }
        }
        return image;
        
    }
}