class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();
        String ans="";
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(st.size()>=1){
                   ans+=ch;
                }
                st.push(ch);
            }
            else{
                if(st.size()>1){
                    ans+=ch;
                    
                }
                st.pop();
            }
        }
        return ans;
        
    }
}