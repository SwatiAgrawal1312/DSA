class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n=bottomLeft.length;
        long maxside=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                // width
                int val1=Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int val2=Math.min(topRight[i][0],topRight[j][0]);
                int width=val2-val1;

                // height
                int v1=Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                int v2=Math.min(topRight[i][1],topRight[j][1]);
                int height=v2-v1;
                int side=Math.min(height,width);
                maxside=Math.max(maxside,side);
            }
        }
        return maxside*maxside;
        
    }
}