class Solution {
    public String makeFancyString(String s) {
        StringBuilder st=new StringBuilder();
        st.append(s.charAt(0));
        int count=1;
        
        for(int i=1;i<=s.length()-1;i++){
            if(i>0 && s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                count=1;
            }
            if(count<3){
                st.append(s.charAt(i));
            }

            

            
            

        }
        return st.toString();
       
       
        
    }
}