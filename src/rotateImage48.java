public class rotateImage48 {

    /*
    image ratotion模板套用：如果是顺时针旋转，那么先上下替换，再swap值，如果是逆时针那么先左右替换，再swap值
     */

    public void rotateMatrixClockwise(int[][] matrix){

        int n = matrix.length;
        //先上下替换
        for(int i = 0; i < n / 2; i++){
            for(int j = 0; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }
        for(int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void rotateMatrixAntiClockwise(int[][] matrix){

        int n = matrix.length;
        //先左右换
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n -j - 1] = tmp;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
