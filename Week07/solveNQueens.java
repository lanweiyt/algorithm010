import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class solveNQueens {

    int n;
    List<List<String>> ret = new LinkedList<>();

    boolean[] uaCol;
    boolean[] uaMain;
    boolean[] uaVice;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for(char[] chars : board){
            Arrays.fill(chars, '.');
        }
        uaCol = new boolean[n];
        uaMain = new boolean[2 * n - 1];
        uaVice = new boolean[2 * n - 1];
        backtrack(0);
        return ret;
    }
    public void backtrack(int row){
        if(row == n){
            List<String> track = new LinkedList<>();
            for(char[] chars : board){
                track.add(new String(chars));
            }
            ret.add(track);
            return;
        }
        for(int i = 0; i < n; i++){
            if(uaCol[i] || uaMain[row - i + n - 1] || uaVice[row + i]){
                continue;
            }
            board[row][i] = 'Q';
            uaCol[i] = true;
            uaMain[row - i+ n - 1] = true;
            uaVice[row + i] = true;

            backtrack(row + 1);

            board[row][i] = '.';
            uaCol[i] = false;
            uaMain[row - i + n - 1] = false;
            uaVice[row + i] = false;
        }
    }



    // List<Integer> col = new ArrayList<>();
    // List<Integer> pie = new ArrayList<>();
    // List<Integer> na = new ArrayList<>();

    // public List<List<String>> solveNQueens(int n) {
    //     List<List<String>> res = new ArrayList<>();
    //     dfs(0, n, res);
    //     return res;
    // }

    // private void dfs(int crow, int column,List<List<String>> res) {
    //     if (crow == column) {
    //         res.add(explain(col, column));
    //         return;
    //     }
    //     for (int i = 0; i < column; i++) {
    //         if (!col.contains(i) && !pie.contains(crow - i) && !na.contains(crow + i)) {
    //             col.add(i);
    //             pie.add(crow - i);
    //             na.add(crow + i);
    //             dfs(crow + 1, column, res);
    //             col.remove(col.size() - 1);
    //             pie.remove(pie.size() - 1);
    //             na.remove(na.size() - 1);
    //         }
    //     }
    // }

    // private List<String> explain(List<Integer> list, int n) {
    //     List<String> res = new ArrayList<>();
    //     for (int i = 0; i < list.size(); i++) {
    //         StringBuilder sb = new StringBuilder();
    //         for (int k = 0; k < n; k++) {
    //             sb.append(k == list.get(i) ? "Q" : ".");
    //         }
    //         res.add(sb.toString());
    //     }
    //     return res;
    // }
}
