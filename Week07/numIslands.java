public class numIslands {

    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};

    int rowLength;
    int columnLength;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        rowLength = grid.length;
        columnLength = grid[0].length;

        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfsMarking(grid, i, j);
                    n++;
                }

            }
        }

        return n;
    }

    private void dfsMarking(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row > rowLength - 1 || column > columnLength - 1) {
            return;
        }
        if (grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        for (int i = 0; i < dx.length; i++) {
            dfsMarking(grid, row + dx[i], column + dy[i]);
        }
    }
}
