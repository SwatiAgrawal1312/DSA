class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n=26;
        long matrix[][]=new long[n][n];
        long INF=(long)1e12;
       
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    matrix[i][j]=0;
                }else{
                    matrix[i][j]=INF;
                }
            }

        }
        for(int i=0;i<original.length;i++){
           int x= original[i]-'a';
           int y=changed[i]-'a';
           matrix[x][y]=Math.min(matrix[x][y],cost[i]);           

            
        }

        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][via]!=INF && matrix[via][j]!=INF ){
                        matrix[i][j]=Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);

                    }
                   
                }
            }
        }
        long sum=0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i) != target.charAt(i)){
                int x=source.charAt(i)-'a';
                int y=target.charAt(i)-'a';
                if(matrix[x][y]==INF){
                    return -1;
                }
                sum+=matrix[x][y];

            }

        }
        return sum;
        
    }
}