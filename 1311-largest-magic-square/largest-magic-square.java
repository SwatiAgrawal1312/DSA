class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int rowcumsum[][]=new int[m][n];
        for(int i=0;i<m;i++){
            rowcumsum[i][0]=grid[i][0];
            for(int j=1;j<n;j++){
                rowcumsum[i][j]=rowcumsum[i][j-1]+grid[i][j];
            }
        }
        int colcumsum[][]=new int[m][n];
        for(int j=0;j<n;j++){
            colcumsum[0][j] = grid[0][j];
            for(int i=1;i<m;i++){
                 colcumsum[i][j] = colcumsum[i-1][j] + grid[i][j];
            }
        }
        for(int side=Math.min(m,n);side>=2;side--){
            for(int i=0;i+side-1<m;i++){
                for(int j=0;j+side-1<n;j++){
                    int targetsum=rowcumsum[i][j+side-1]-(j>0?rowcumsum[i][j-1]:0);
                    boolean allsame=true;
                    // check rows
                    for(int r=i+1;r<i+side;r++){
                        int rowsum=rowcumsum[r][j+side-1]-(j>0?rowcumsum[r][j-1]:0);
                        if(rowsum!=targetsum){
                            allsame=false;
                            break;
                        }
                    }if(!allsame) continue;

                    // check columns
                    for(int c=j;c<j+side;c++){
                        int colsum=colcumsum[i+side-1][c]-(i>0?colcumsum[i-1][c]:0);
                        if(colsum!=targetsum){
                            allsame=false;
                            break;
                        }
                    }if(!allsame) continue;
                    // check diagonal and anti-diagonal
                    int diag=0;
                    int antidiag=0;
                    for(int k=0;k<side;k++){
                        diag+=grid[i+k][j+k];
                        antidiag+=grid[i+k][j+side-1-k];
                    }
                    if(diag==targetsum && antidiag==targetsum){
                        return side;
                    }


                }
            }

        }
        return 1;
        
    }
}