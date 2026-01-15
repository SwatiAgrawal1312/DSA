class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxhbarscount=1;
        int maxvbarscount=1;

        int currhbarscount=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1){
                currhbarscount++;

            }else{
                currhbarscount=1;

            }
            maxhbarscount=Math.max(maxhbarscount,currhbarscount);
        }

        int currvbarscount=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1){
                currvbarscount++;

            }else{
                currvbarscount=1;

            }
            maxvbarscount=Math.max(maxvbarscount,currvbarscount);
        }
        int side=Math.min(maxhbarscount,maxvbarscount)+1;
        return side*side;
       
        
    }
}