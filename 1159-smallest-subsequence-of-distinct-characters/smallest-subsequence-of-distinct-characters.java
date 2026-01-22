class Solution {
    public String smallestSubsequence(String s) {
          int last_idx[]=new int[26];
        boolean seen[]=new boolean[26];
        for(int i=0;i<s.length();i++){
            last_idx[s.charAt(i)-'a']=i;
        }
        Stack<Character> st=new Stack();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(seen[ch-'a']){
                continue;
            }
            
            while(!st.isEmpty() && ch<st.peek() && last_idx[st.peek()-'a']>i){
                seen[st.pop()-'a']=false;
            }
            st.push(ch);
            seen[ch-'a']=true;
        }
        StringBuilder sb=new StringBuilder();
        for(char c:st){
            sb.append(c);

        }
        return sb.toString();
        
        
    }
}