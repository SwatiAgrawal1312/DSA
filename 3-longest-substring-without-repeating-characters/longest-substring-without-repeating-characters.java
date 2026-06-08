class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashSet<Character> hs=new HashSet<>();
        int j=0;
        int maxLength=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            while(hs.contains(ch)){
                hs.remove(s.charAt(j));
                j++;
            }
            hs.add(ch);
            maxLength=Math.max(maxLength,i-j+1);

        }
        return maxLength;
        
    }
}