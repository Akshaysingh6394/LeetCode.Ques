class Solution {
    public boolean dfs(char[][] board, int i, int j, int idx, boolean[][] vis, String word) {
        if (idx == word.length() - 1) return true;

        vis[i][j] = true;

        int r = board.length, c = board[0].length;

        if (i - 1 >= 0 && !vis[i - 1][j] && board[i - 1][j] == word.charAt(idx + 1) && dfs(board, i - 1, j, idx + 1, vis, word))
            return true;
        if (i + 1 <= r - 1 && !vis[i + 1][j] && board[i + 1][j] == word.charAt(idx + 1) && dfs(board, i + 1, j, idx + 1, vis, word))
            return true;
        if (j - 1 >= 0 && !vis[i][j - 1] && board[i][j - 1] == word.charAt(idx + 1) && dfs(board, i, j - 1, idx + 1, vis, word))
            return true;
        if (j + 1 <= c - 1 && !vis[i][j + 1] && board[i][j + 1] == word.charAt(idx + 1) && dfs(board, i, j + 1, idx + 1, vis, word))
            return true;

        vis[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {

        int r = board.length, c = board[0].length;

        boolean[][] vis = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, vis, word)) return true;
            }
        }
        return false;
    }
}