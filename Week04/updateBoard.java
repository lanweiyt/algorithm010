class Solution {
    int[] xKey = {0,0,1,-1,1,1,-1,-1};
    int[] yKey = {1,-1,0,0,1,-1,1,-1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];

        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return board;
        }
        handler(board, i, j);
        return board;
    }

    private void handler(char[][] board, int i, int j) {
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return;
        }

        if (board[i][j] == 'E') {
            int boomCount = getBoomCount(board, i, j);
            if (boomCount == 0) {
                board[i][j] = 'B';
                for (int k = 0; k < 8; k++) {
                    int x = i + xKey[k];
                    int y = j + yKey[k];
                    if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                        if (board[x][y] == 'E') {
                            handler(board, x, y);
                        }
                    }
                }
            } else {
                board[i][j] = String.valueOf(boomCount).toCharArray()[0];
                return;
            }
        }

    }


    private int getBoomCount(char[][] board, int i, int j) {
        int boom = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + xKey[k];
            int y = j + yKey[k];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
                if (board[x][y] == 'M') {
                    boom ++;
                }
            }
        }
        return boom;
    }
}