class Solution {
    public String digitSum(String s, int k) {
        if(s.length()==k){
            return s;
        }
        while(s.length()>k){
            StringBuilder sb=new StringBuilder();
            int sum=0;
            int count=0;
            for(int i=0;i<s.length();i++){
                sum+=s.charAt(i)-'0';
                count++;
                if(count==k||i==s.length()-1){
                    sb.append(sum);
                     count=0;
                sum=0;
                }
               

            }
            s=sb.toString();

        }
        return s;
       
        
    }
}