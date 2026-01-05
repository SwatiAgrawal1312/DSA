class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestsum=100000;
        int n=nums.length;
        for(int k=0;k<=n-3;k++){
            int left=k+1;
            int right=n-1;
            while(left!=right){
                int sum=nums[k]+nums[left]+nums[right];
                if(Math.abs(target-sum)<Math.abs(target-closestsum)){
                    closestsum=sum;
                }
                if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return closestsum;
        
    }
}