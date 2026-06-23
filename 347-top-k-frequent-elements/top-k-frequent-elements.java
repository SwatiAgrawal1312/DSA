class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> min_heap=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());//by default min_heap

        for(Map.Entry<Integer,Integer> x:hm.entrySet()){
            min_heap.offer(x);
            if(min_heap.size()>k){
                min_heap.poll();
            }

        }
        int ans[]=new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=min_heap.poll().getKey();
        }
        return ans;

        
    }
}
// TC:-o(n)+o(n)+o(nlogn)+o(k)
// SC:-o(n)+o(n)+o(k)