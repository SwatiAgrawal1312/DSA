class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums=new ArrayList<>();
        int fact=1;
        for(int i=1;i<=n;i++){
            nums.add(i);
            if(i<n){
            fact*=i;
            }


        }
        k--;
        StringBuilder st=new StringBuilder();
        while(!nums.isEmpty()){
           int index=k/fact;
           st.append(nums.get(index));
           nums.remove(index);
           if(nums.isEmpty()){
            break;
           }
           k=k%fact;
           fact=fact/nums.size();


        }
        return  st.toString();
        
    }
}