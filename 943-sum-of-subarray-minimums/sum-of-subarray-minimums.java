class Solution {
    public int sumSubarrayMins(int[] arr) {
        int RSE[]=new int[arr.length];
        int LSE[]=new int[arr.length];
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        for(int i=0;i<arr.length;i++){
          while(!st1.isEmpty() && arr[i]<=arr[st1.peek()]){
            st1.pop();

          }
          LSE[i]=st1.isEmpty()?-1:st1.peek();
          st1.push(i);
        }
        for(int i=arr.length-1;i>=0;i--){
            while(!st2.isEmpty() && arr[i]<arr[st2.peek()]){
                st2.pop();
            }
            
            RSE[i]=st2.isEmpty()?arr.length:st2.peek();
            st2.push(i);


        }
        long ans=0;
        int mo=1000000007;
        for(int i=0;i<arr.length;i++){
            long left=i-LSE[i];
            long right=RSE[i]-i;
            ans=(ans+(long)arr[i]*left*right%mo)%mo;

        }
        return (int)ans;

        
    }
}