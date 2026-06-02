class Solution {
    public int minimumCost(int[] cost) {
       Arrays.sort(cost);
       int i=0;
       int j=cost.length-1;
       while(i<j){
        int temp=cost[i];
        cost[i]=cost[j];
        cost[j]=temp;
        i++;
        j--;
       }
       int sum=0;
       for(int k=0;k<cost.length;k++){
        if(k%3!=2){
        sum+=cost[k];
        }

       }
       return sum;
    }
}