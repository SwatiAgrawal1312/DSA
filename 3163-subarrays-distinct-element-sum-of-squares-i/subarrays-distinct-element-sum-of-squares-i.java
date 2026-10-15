class Solution {
    public int sumCounts(List<Integer> nums) {
        
        int ans=0;
        HashSet<Integer> hs;
        for(int i=0;i<nums.size();i++){
            int count =0;
            hs=new HashSet<>();
            for(int j=i;j<nums.size();j++){
                hs.add(nums.get(j));
                count=hs.size();
                ans+=count*count;


            }
        }
        return ans;
        
    }
}