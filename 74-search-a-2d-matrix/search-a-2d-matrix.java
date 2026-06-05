class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length-1;
        for(int i=0;i<m;i++){
            int j=0;
            while(j<=n){
                int mid=j+(n-j)/2;
                if(matrix[i][mid]==target){
                    return true;
                }
                if(matrix[i][mid]<target){
                    j=mid+1;
                }
                else{
                    n=mid-1;
                }
            }
        }
        return false;
        
    }
}