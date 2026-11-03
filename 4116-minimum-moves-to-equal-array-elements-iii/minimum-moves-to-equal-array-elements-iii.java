class Solution {
    public int minMoves(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int moves=0;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(nums[i],maxi);
        }
        for(int i=0;i<nums.length;i++){
            moves+=maxi-nums[i];

        }
        return moves;
        
    }
}