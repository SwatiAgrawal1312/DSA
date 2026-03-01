class Solution {
    public int minPartitions(String n) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n.length();i++){
            char ch=n.charAt(i);
            int value=ch-'0';
            if(value>max){
                max=value;
            }
        }
        return max;
        
    }
}