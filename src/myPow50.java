public class myPow50 {

    /*
    一道很简单的题，用的却是巧思来实现logN的算法。
    recursive的计算half值然后再合并就好，很漂亮的recursion实现方法
     */

    class Solution {
        public double myPow(double x, int n) {
            if(n == 0)
                return 1.0;
            double half = myPow(x, n / 2);
            if(n % 2 == 0){
                return half * half;
            }else{
                if(n > 0)
                    return half * half * x;
                else
                    return (half * half) / x;
            }
        }

    }
}
