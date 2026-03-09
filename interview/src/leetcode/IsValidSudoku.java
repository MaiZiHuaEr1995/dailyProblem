package leetcode;

public class IsValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int m = board[i][j] - '0';
                int n = (i / 3) * 3 + (j / 3);
                if (row[i][m] || col[j][m] || block[n][m]) {
                    return false;
                }
                row[i][m] = true;
                col[j][m] = true;
                block[n][m] = true;
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][]  block = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    // 第i行数字index出现的次数+1
                    row[i][index]++;
                    // 第j行数字index出现的次数+1
                    col[j][index]++;
                    block[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || col[j][index] > 1 || block[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
