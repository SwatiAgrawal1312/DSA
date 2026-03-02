class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid.length;
        int endZeroes[]=new int[n];
        for(int i=0;i<n;i++){
            int j=n-1;
            int count=0;
            while(j>=0 && grid[i][j]==0){
                count++;
                j--;

            }
            endZeroes[i]=count;
        }
        int result=0;
        

        for (int row = 0; row < n; row++) {
            int need = n - row - 1;

            int i = row;
            while (i < n && endZeroes[i] < need) {
                i++;
            }

            if (i == n) return -1; 

            result += i - row;

           
            while (i > row) {
                int temp = endZeroes[i];
                endZeroes[i] = endZeroes[i - 1];
                endZeroes[i - 1] = temp;
                i--;
            }
        }

        return result;
        
    }
}