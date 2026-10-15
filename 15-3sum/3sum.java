class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++){
            if(i>=1 && nums[i]==nums[i-1]){
                continue;

            }

            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int res=nums[i]+nums[j]+nums[k];
                if(res==0){
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]){
                        j++;
                    }
                    while(k>j && nums[k]==nums[k+1]){
                        k--;
                    }
                    
                }
                else if(res>0){
                    k--;
                }
                else{
                    j++;

                }
            }
        }
        return list;
    }
}