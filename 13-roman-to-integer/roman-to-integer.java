class Solution {
     public int checkvalue(char ch){
        switch(ch){
        case 'I':return 1;
        case 'V':return 5;
        case 'X':return 10;
        case 'L':return 50;
        case 'C':return 100;
        case 'D':return 500;
        case 'M':return 1000;
        default:return -1;
    }
    }
   
    public int romanToInt(String s) {
        int ans=0;
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(i+1==s.length()){
                ans+=checkvalue(ch);
                break;
            }
            if(checkvalue(ch)>=checkvalue(s.charAt(i+1))){

                ans+=checkvalue(ch);
                i+=1;

            }
            else {
                ans+=checkvalue(s.charAt(i+1))-checkvalue(ch);
                i+=2;
            }


        }
        return ans;
        
    }
   
}