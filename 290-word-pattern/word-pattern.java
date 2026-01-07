class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] st=s.split("\\s+");
        if(pattern.length()!=st.length){
            return false;
        }
        HashMap<Character,String> map=new HashMap<>();
        for(int i=0;i<st.length;i++){
            char ch=pattern.charAt(i);
           String word=st[i];
           if(map.containsKey(ch)){
             if(!map.get(ch).equals(word)){
                return false;
             }

           }else{
            if(map.containsValue(word)){
                return false;
            }
          

            map.put(ch,word);


           }
            
           
        }
        return true;
        

       

    }
}