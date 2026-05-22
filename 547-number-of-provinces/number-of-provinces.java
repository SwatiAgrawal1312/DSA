class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
       
        boolean visited[]=new boolean[n];
        int province=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected,i,visited);
                province++;
            }
        }
        return province;
        
        
    }
    public void dfs(int[][] isConnected,int city,boolean visited[]){
        visited[city]=true;
        for(int j=0;j<isConnected.length;j++){
           if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected,j,visited);
            }  
        }
    }
    

    
}