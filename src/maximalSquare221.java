public class maximalSquare221 {

    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sums = new int[row + 1][col + 1];
        int ans = 0;

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i-1][j-1] - '0';
            }
        }

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                for(int k = Math.min((row - i + 1),(col - j + 1)); k > 0; k--){

                    int sum = sums[i + k -1][j + k -1] - sums[i + k -1][j - 1]
                            - sums[i - 1][j + k -1] + sums[i - 1][j - 1];

                    if(sum == k*k){
                        ans = Math.max(sum, ans);
                    }
                }

            }
        }
        return ans;
    }


}
