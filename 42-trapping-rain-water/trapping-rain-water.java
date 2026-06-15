class Solution {
    public int trap(int[] height) {
        int left[]=new int[height.length];
        int right[]=new int[height.length];
        left[0]=height[0];
        right[height.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++){
            left[i]=Math.max(left[i-1],height[i]);

        }
        for(int j=height.length-2;j>=0;j--){
            right[j]=Math.max(right[j+1],height[j]);

        }
        int trappedwater=0;
        for(int k=0;k<height.length;k++){
            int waterlevel=Math.min(left[k],right[k]);
            trappedwater+=waterlevel-height[k];
           
        }
        return trappedwater;
        
    }
}