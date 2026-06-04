class Solution {
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
        int arr[]=new int[2];
        HashMap<Integer,Integer> hm=new HashMap<>();
        int s=0;
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        for(int x:hm.keySet()){
            if(hm.get(x)>1){
                arr[0]=x;
            }
        }
        int sum_n=n*(n+1)/2;
        int diff=s-sum_n;
        arr[1]=arr[0]-diff;
        return arr;
        
    }
}