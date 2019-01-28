import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class largestOverlap835 {

    /*
    Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
     */

    /*
    solution
    */

    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2*N+1][2*N+1];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                                count[i-i2 +N][j-j2 +N] += 1;

        int ans = 0;
        for (int[] row: count)
            for (int v: row)
                ans = Math.max(ans, v);
        return ans;
    }

    /*
    correct answer from discussion:

    Intuition:
    If we do brute force, we have 2N horizontal possible sliding, 2N vertical sliding and N^2 to count overlap area.
    We get O(N^4) solution and it may get accepted.
    But we waste out time on case of sparse matrix.

    Explanation:
    Assume index in A and B is [0, N * N -1].

    Loop on A, if value == 1, save a coordinates i / N * 100 + i % N to LA.
    Loop on B, if value == 1, save a coordinates i / N * 100 + i % N to LB.
    Loop on combination (i, j) of LA and LB, increase count[i - j] by 1.
    If we slide to make A[i] orverlap B[j], we can get 1 point.
    Loop on count and return max values.
    I use a 1 key hashmap. Assume ab for row and cd for col, I make it abcd as coordinate.
    For sure, hashmap with 2 keys will be better for understanding.

    Time Complexity:
    As reminded by @specialzsp,
    O(N^2) for preparing, and O(AB) for loop.
    O(AB + N^2)
     */
    public int largestOverlapCorrectAnswer(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; ++i) if (A[i / N][i % N] == 1) LA.add(i / N * 100 + i % N);
        for (int i = 0; i < N * N; ++i) if (B[i / N][i % N] == 1) LB.add(i / N * 100 + i % N);
        for (int i : LA)
            for (int j : LB)
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;
    }

    /*
    Brute Force: shit A 跟 B 直到他们的左边跟上面没有整排的0，然后用xor合并两个matrix，然后看有几个1s
    事实证明这个方法不对

     */

    public int largestOverlapWrongAnswer(int[][] A, int[][] B) {

        shiftMatrixByRow(A,0, A.length-1);
        shiftMatrixByCol(A,0, A[0].length-1);
        shiftMatrixByRow(B,0, B.length-1);
        shiftMatrixByCol(B,0, B[0].length-1);

        for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        for(int i=0; i<B.length; i++){
            for(int j=0; j<B[0].length; j++){
                System.out.print(B[i][j]+" ");
            }
            System.out.println();
        }

        int m=A.length>=B.length?A.length:B.length;
        int n=A[0].length>=B[0].length?A[0].length:B[0].length;
        int[][] res=new int[m][n];
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                int Aval=0;
                if(i<A.length && j<A[0].length){
                    Aval=A[i][j];
                }
                int Bval=0;
                if(i<B.length && j<B.length){
                    Bval=B[i][j];
                }
                res[i][j]=Aval&Bval;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(res[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }


    private void shiftMatrixByRow(int[][] A, int start, int end){
        if(start==end){
            return;
        }
        if(checkRow(A, start)){
            swapRow(A, start);
        }
        shiftMatrixByRow(A,start+1,end);
    }

    private boolean checkRow(int[][] A, int row){
        for(int i=0; i<A[0].length; i++){
            if(A[row][i]!=0){
                return false;
            }
        }
        return true;
    }

    private void swapRow(int[][] A, int row){
        for(int i=0; i<A[0].length; i++){
            int tmp=A[row][0];
            A[row][i]=A[row+1][i];
            A[row+1][i]=tmp;
        }
    }

    private void shiftMatrixByCol(int[][] A, int start, int end){
        if(start==end){
            return;
        }
        if(checkByCol(A,start)){
            swapCol(A,start);
        }
        shiftMatrixByCol(A, start+1,end);
    }

    private boolean checkByCol(int[][] A, int start){
        for(int i=0; i<A.length; i++){
            if(A[i][start]!=0){
                return false;
            }
        }
        return true;
    }

    private void swapCol(int[][] A, int start){
        for(int i=0; i<A.length; i++){
            int tmp=A[i][start];
            A[i][start]=A[i][start+1];
            A[i][start+1]=tmp;
        }
    }

}
