class Solution {
    public boolean isPalindrome(String s,int i,int idx){
        int left=idx;
        int right=i;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
           
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int start=0;
        int maxi=1;
        for(int idx=0;idx<s.length();idx++){
            for(int i=idx;i<s.length();i++){
                if(isPalindrome(s,i,idx)){
                    int length=i-idx+1;
                    if(maxi<length){
                        maxi=length;
                        start=idx;
                    }


                }
            }
        }
        return s.substring(start,start+maxi);
        
    }
}
