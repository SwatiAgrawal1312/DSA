class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();

        char board[][]=new char[n][n];
        for(char boards[]:board){
            Arrays.fill(boards,'.');
        }
        solver(board,0,n,ans);
        return ans;
        
    }
    public void solver(char board[][],int row,int n,List<List<String>> ans){
        if(row==n){
           List<String> curr=new ArrayList<>();
           for(int i=0;i<n;i++){
            curr.add(new String(board[i]));
           }
           ans.add(curr);
           return;
        }
        for(int j=0;j<n;j++){
            if(issafe(board,row,j,n)){
            board[row][j]='Q';
            solver(board,row+1,n,ans);
            board[row][j]='.';
        }
        }
        

        
    }
    public boolean issafe(char board[][],int row,int col,int n){
        // Horizontal
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }
        // vertical
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // left diagonal
        int r=row;
        int c=col;
        while(r>0 && c>0){
            if(board[r-1][c-1]=='Q'){
                return false;
            }
            r--;
            c--;
        }
        // right diagonal
        r=row;
        c=col;
        while(r>0 && c<n-1){
            if(board[r-1][c+1]=='Q'){
                return false;
            }
            r--;
            c++;
        }
        return true;


    }
}