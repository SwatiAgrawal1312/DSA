class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s=countAndSay(n-1);
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            int count=1;
            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                count++;
                i++;

            }
            
            sb.append(count);
            sb.append(ch);
            i++;

        }
        return sb.toString();
        
    }
}