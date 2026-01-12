class Solution {
    public int residuePrefixes(String s) {
        boolean seen[]=new boolean[26];
        int distinct=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            int value=s.charAt(i)-'a';
            if(!seen[value]){
                seen[value]=true;
                distinct++;
            }
            if(distinct==(i+1)%3){
                count++;
            }

        }
        return count;
        
    }
}