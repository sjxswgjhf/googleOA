import java.util.Arrays;

public class longestIncreasingPath329 {


    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;

        int[][] cur = new int[m][n];

        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int tmp = dfs(matrix, cur, i, j, m, n);
                max = Math.max(tmp, max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int[][] cur, int i, int j, int m, int n){
        if(cur[i][j] != 0){
            return cur[i][j];
        }
        int max = 1;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]){
                continue;
            }
            int path = 1 + dfs(matrix, cur, x, y, m, n);
            max = Math.max(path, max);
        }
        cur[i][j] = max;
        return max;
    }


}
