class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        int leftmin[]=new int[heights.length];
        int rightmin[]=new int[heights.length];
        

        for(int i=heights.length-1;i>=0;i--){
            while(!st1.isEmpty()&& heights[i]<=heights[st1.peek()]){
                st1.pop();
            }
            rightmin[i]=st1.isEmpty()?heights.length:st1.peek();
            st1.push(i);
            
        }
        for(int k=0;k<heights.length;k++){
            while(!st2.isEmpty()&& heights[k]<=heights[st2.peek()]){
                st2.pop();
            }
            leftmin[k]=st2.isEmpty()?-1:st2.peek();
            st2.push(k);
        }
        int max=Integer.MIN_VALUE;
        for(int j=0;j<heights.length;j++){
            int width=rightmin[j]-leftmin[j]-1;
            int area=width*heights[j];
            max=Math.max(max,area);

        }
        return max;
        
    }
}