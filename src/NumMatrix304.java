public class NumMatrix304 {


    //TLE
    class NumMatrix {

        int[][] nums;

        public NumMatrix(int[][] matrix) {
            this.nums = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int row = row2 - row1 + 1;
            int col = col2 - col1 + 1;
            int sum = 0;
            for(int i = row1; i < row + row1; i++){
                for(int j = col1; j < col1 + col; j++){
                    sum += nums[i][j];
                }
            }
            return sum;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


class NumMatrixO1 {

    int[][] nums;

    public NumMatrixO1(int[][] matrix) {
        if(matrix == null ||
                matrix.length ==0 ||
                matrix[0].length ==0 )
            return;
        int row = matrix.length;
        int col = matrix[0].length;
        nums = new int[row+1][col+1];

        for(int i = 1; i < row + 1; i++){
            for(int j = 1; j < col + 1; j++){
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1] - nums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = nums[row2 + 1][col2 + 1] - nums[row1][col2+1] - nums[row2+1][col1] + nums[row1][col1];
        return res;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


}

