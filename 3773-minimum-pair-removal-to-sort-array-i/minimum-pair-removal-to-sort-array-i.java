class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);

        }
        
        int operation=0;
       
        while(!is_sorted(list)){
            int mini=Integer.MAX_VALUE;
            int index=0;
            for(int i=0;i<list.size()-1;i++){
               int sum=list.get(i)+list.get(i+1);
               if(sum<mini){
                mini=sum;
                index=i;
               }
                
            }
            list.set(index,mini);
            list.remove(index+1);
            operation++;

        }
        return operation;
    }
    public boolean is_sorted(List<Integer> list){
            for(int i=1;i<list.size();i++){
                if(list.get(i)<list.get(i-1)){
                    return false;
                }
            }
            return true;
        }


       
      
        
    
}