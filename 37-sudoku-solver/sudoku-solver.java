class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isvalid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isvalid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == c){
                return false; // column check
            }
            if(board[row][i] == c){ // row check
                return false;
            }
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c){ // 3x3 grid check
                return false;
            }
        }
        return true;
    }
}