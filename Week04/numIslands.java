class Solution {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfsMarking(grid, i, j, grid.length, grid[i].length);
                    n++;
                }

            }
        }

        return n;
    }

    private static void dfsMarking(char[][] grid, int row, int column, int rowLength, int columnLength) {
        if (row < 0 || column < 0 || row > rowLength - 1 || column > columnLength - 1) {
            return;
        }
        if (grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        dfsMarking(grid, row, column + 1, rowLength, columnLength);
        dfsMarking(grid, row, column - 1, rowLength, columnLength);
        dfsMarking(grid, row + 1, column, rowLength, columnLength);
        dfsMarking(grid, row - 1, column, rowLength, columnLength);
    }
}