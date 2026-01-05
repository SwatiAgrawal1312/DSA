class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int minsum=Integer.MAX_VALUE;
        int count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0){
                    count++;
                }
                sum+=Math.abs(matrix[i][j]);
                minsum=Math.min(minsum,Math.abs(matrix[i][j]));

            }
        }
        if(count%2==0){
            return sum;
        }else{
            return sum-2*minsum;
        }
        
    }
}