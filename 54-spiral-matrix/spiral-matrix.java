class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        int i=0;
        int j=0;
        while(i<=row && j<=col){
            // col change
        for(int x=j;x<=col;x++){
            res.add(matrix[i][x]);
        }
        
        for(int y=i+1;y<=row;y++){
            res.add(matrix[y][col]);
            
        }
        if(i<row){
        for(int x=col-1;x>=j;x--){
            res.add(matrix[row][x]);
            
        }
        }
        if(j<col){
        for(int y=row-1;y>i;y--){
            res.add(matrix[y][j]);
            
        }
        }
        i++;
        j++;
        col--;
        row--;
        
        }
        return res;
        
    }
}