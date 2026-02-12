class Solution {
    public boolean check_balanced(int freq[]){
        int common=0;
        for(int i=0;i<26;i++){
            if(freq[i]==0){
                continue;
            }else if(common==0){
                common=freq[i];
            }
            if(common!=freq[i]){
                return false;
            }
        }
        return true;
    }
    public int longestBalanced(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            int freq[]=new int[26];
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                freq[ch-'a']++;
                if(check_balanced(freq)){
                   max=Math.max(max,j-i+1);
                }

            }
        }
        return max;
    }
}