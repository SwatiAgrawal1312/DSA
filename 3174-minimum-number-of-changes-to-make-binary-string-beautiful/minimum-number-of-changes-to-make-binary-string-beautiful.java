class Solution {
    public int minChanges(String s) {
      int change=0;
      int i=1;
      while(i<s.length()){
        if(s.charAt(i)!=s.charAt(i-1)){
           change++;
        }
        i=i+2;
      }
      return change;
        




     
        
        
    }
}