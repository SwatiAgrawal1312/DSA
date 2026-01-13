class Solution {
    private double totalarea;
        private int[][] squares;
        private boolean check(double yline){
            double areabelow=0.0;
            for(int[] s:squares){
                double y0=s[1];
                double l=s[2];
                if(y0<yline){
                    areabelow += l * Math.min(yline - y0, l);
                }
            }
            return areabelow>=totalarea*0.5;
        }

        public double separateSquares(int[][] squares){
            this.squares=squares;
            totalarea=0.0;
            double maxy=0.0;
            for(int[] s:squares){
                double l=s[2];
                totalarea+=l*l;
                maxy = Math.max(maxy, s[1] + l);
            }
            double low=0.0;
            double high=maxy;
            double eps=1e-5;
            while(high-low>eps){
                double mid=(low+high)/2.0;
                if(check(mid)){
                    high=mid;

                }
                else{
                    low=mid;
                }
            }
            return high;
        }
}
       
        
    
