class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> hm=new HashMap<>();
        int j=0;
        int maxLength=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hm.containsKey(ch)){
               j=Math.max(j,hm.get(ch)+1);
                
            }
            hm.put(ch,i);
            maxLength=Math.max(maxLength,i-j+1);

        }
        return maxLength;
        
    }
}