class Solution {
    public boolean compare(String s1, String s2,int i){
        int j=i,k=0;
        int l2=s2.length();
        int count=0;
        for(int t=i;t<s1.length();t++){
            count++;

        }
        if(count<l2){
            return false;
        }
        
       while(j<s1.length() && k<s2.length()){
        if(s1.charAt(j)!=s2.charAt(k)){
            return false;
        }
        j++;
        k++;
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