class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            count+=waviness(i);

            
        }
        return count;
        
    }
    public int waviness(int x){
        String s=String.valueOf(x);
        if(s.length()<3){
            return 0;
        }
        int add=0;

        for(int i=1;i<s.length()-1;i++){
            char first=s.charAt(i-1);
            char second=s.charAt(i);
            char third=s.charAt(i+1);
            if(second>first && second>third){
                add+=1;

            }else if(second<first && second<third){
                add+= 1;
            }
            
        }
        return add;
    }
}