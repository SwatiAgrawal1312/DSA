class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.size();i++){
            int sum=0;
            for(int j=i;j<nums.size();j++){
                
                int sz=j-i+1;
                if(sz>r){
                    break;
                }
                sum+=nums.get(j);
                if(sum>0 && l<=sz && r>=sz){
                    min=Math.min(min,sum);
                }

                
            }
        }
        return min==Integer.MAX_VALUE?-1:min;

        
    }
}