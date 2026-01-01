class Solution {
    public int[] plusOne(int[] digits) {
        
      
        int i=digits.length-1;
        while(i>=0){
            if(digits[i]<9){
                digits[i]+=1;
                return digits;
            }
            else if(digits[i]==9){
                digits[i]=0;
            }
            i--;
        }
        int result[]=new int[digits.length+1];
        result[0]=1;
        return result;
        


       
       
       
        
    }
}