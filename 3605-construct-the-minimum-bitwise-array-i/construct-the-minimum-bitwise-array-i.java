class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<1000;j++){
                if((j|(j+1))==nums.get(i)){
                    result[i]=j;
                    break;
                }
                else{
                    result[i]=-1;
                }    
            }
        }
        return result;
        
    }
}