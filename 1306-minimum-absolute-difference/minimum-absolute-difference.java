class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(arr);
        int mini=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
           int diff=Math.abs(arr[i-1]-arr[i]);
            mini=Math.min(mini,diff);
        }
        
        for(int i=1;i<arr.length;i++){
            
            int f=arr[i-1];
            int s=arr[i];
            if(mini==Math.abs(f-s)){
                List<Integer> ans=new ArrayList<>();
                ans.add(f);
                ans.add(s);
                result.add(ans);

            }
        }

        return result;
    }
}