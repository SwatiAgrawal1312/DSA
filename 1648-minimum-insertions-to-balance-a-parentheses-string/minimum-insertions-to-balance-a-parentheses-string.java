class Solution {
    public int minInsertions(String s) {
        int i=0;
        int count=0;
        int res=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                count++;
                i++;
            }else{
                if(count>0 ){
                    count--;
                }else{
                    res++;
                }

                  if(i+1<s.length() && s.charAt(i+1)==')'){
                    
                    i+=2;
                  }else{
                    res++;
                    i++;
                  }
                
            }
        }
       
            return res+=2*count;
       
        
    }
}