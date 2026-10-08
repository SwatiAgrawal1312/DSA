class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        String ans="";
        for(char ch:s.toCharArray()){
            if(ch=='('){
                count++;
                if(count>=2){
                    ans+=ch;
                }

                

            }
            else{
                if(count>=2){
                    ans+=ch;
                    

                }
                count--;

            }
        }
        return ans;
        
    }
}