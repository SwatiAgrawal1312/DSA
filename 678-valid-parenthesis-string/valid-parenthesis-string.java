class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st1.push(i);
            }else if(ch=='*'){
                st2.push(i);
            }else{
               
                if(!st1.isEmpty()){
                    st1.pop();
                }
                else if(!st2.isEmpty()){
                    st2.pop();
                }
                else{
                    return false;
                }
            }

        }
       
        while(!st1.isEmpty()){
            if(st2.isEmpty()){
                return false;
            }
            else if(st1.peek()>st2.peek()){
            return false;
           }

           
            st1.pop();
            st2.pop();
           
        }

        return st1.isEmpty();

        
    }
}