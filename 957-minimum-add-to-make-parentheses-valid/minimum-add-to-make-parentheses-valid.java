class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int count=0;
        int size=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                
                size++;

            }else{
                if(size>0){ 
                   size--;
                }
                else{
                    
                    count++;
                }
            }
        }
        
        return count+size;
        
    }
}