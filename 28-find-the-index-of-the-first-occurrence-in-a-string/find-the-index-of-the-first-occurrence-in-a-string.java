class Solution {
    public boolean compare(String s1, String s2,int i){
        int start=i;
        if(s1.length()-start<s2.length()){
            return false;
        }
       
        int j=0;
       while(j<s2.length()){
        if(s1.charAt(start+j)!=s2.charAt(j)){
            return false;
        }

        j++;
       
       }
       return true;
    }
    public int strStr(String haystack, String needle) {
        int x1=haystack.length();
        int x2=needle.length();
        if(x1<x2){
            return -1;
        }
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(compare(haystack,needle,i)){
                    return i;
                }
            }
        }
        return -1;
        
    }
}