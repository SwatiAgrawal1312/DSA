class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            result[i]=-1;
            for(int j=0;j<1000;j++){
                if((j|(j+1))==nums.get(i)){
                    result[i]=j;
                    break;
                }
                
            }
        }
        return result;
        
    }
}