public class minSwap801 {


    class Solution {

        int ans = Integer.MAX_VALUE;

        public int minSwap(int[] a, int[] b) {

            dfs(a, b, 0, 0);
            return ans;
        }

        private void dfs(int[] a, int[] b, int index, int cur){
            if(cur >= ans){
                return;
            }
            if(index == a.length){
                ans = Math.min(cur, ans);
                return;
            }

            if(index==0 || a[index] > a[index - 1] && b[index] > b[index - 1]){
                dfs(a, b, index + 1, cur);
            }

            if(index==0 || a[index] > b[index - 1] && b[index] > a[index - 1]){
                swap(a, b, index);
                dfs(a, b, index + 1, cur + 1);
                swap(a, b, index);
            }
        }

        private void swap(int[] a, int[] b, int index){
            int tmp = a[index];

            a[index] = b[index];
            b[index] = tmp;
            return;
        }
    }


    /*
    DP: use swap[] and keep[] to denotes the min swaps to make A[0]~A[i] / B[0]~B[i] strictly increasing
    with/without swap A[i] and B[i]
    */


    public int minSwapDP(int[] a, int[] b) {

        int[] swap = new int[a.length];
        int[] keep = new int[a.length];

        for(int i = 0; i < swap.length; i++){
            swap[i] = Integer.MAX_VALUE;
            keep[i] = Integer.MAX_VALUE;
        }

        swap[0] = 1;
        keep[0] = 0;
        int res = 0;
        for(int i = 1; i < a.length; i++){
            if(a[i] > a[i - 1] && b[i] > b[i - 1]){
                keep[i] = keep[i-1];
                swap[i] = swap[i-1] + 1;
            }

            if(a[i] > b[i-1] && b[i] > a[i-1]){
                keep[i] = Math.min(swap[i-1], keep[i]);
                swap[i] = Math.min(keep[i-1]+1, swap[i]);
            }
        }
        return Math.min(swap[a.length - 1], keep[a.length - 1]);

    }

}
