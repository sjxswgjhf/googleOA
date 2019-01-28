public class multiplyString43 {

    /*
    题目是很简单的要求两个string相乘，里面都是integer char，长度小于100，虽然长度不大，但是肯定是超过double的MAX了
    意味着我们只能拆开做，首先乘积的值的长度肯定是n+m或者n+m-1的长度，取决于最后到底进不进位。那么我们可以建个res array
    然后loop两个str按乘法性质从后往前走，把每对i,j的值放进res，位置重叠贼累加，那么完成loop之后我们的res array里面的数都是0~81直接
    那么我们再次重最后一位开始计算进位就好了，最后return的时候判断到底有多少位的前置0，那么跳过这些0把结果append到string
    buffer里面去就好，最后看是不是999*0这种极限情况，那么sb.length=0，return "0"：sb.toString()
    一道高频逻辑题，感觉挺好的
     */

    class Solution {
        public String multiply(String num1, String num2) {
            int n = num1.length();
            int m = num2.length();
            int[] res = new int[n + m];
            for(int i = n - 1; i >= 0; i--){
                for(int j = m -1 ; j >= 0; j--){
                    int d1 = (int)(num1.charAt(i) - '0');
                    int d2 = (int)(num2.charAt(j) - '0');
                    int val = d1 * d2;
                    res[i + j + 1] += val;
                }
            }
            int carry = 0;
            for(int i = m + n - 1; i >=0; i--){
                int tmp = (res[i] + carry) % 10;
                carry = (res[i] + carry) / 10;
                res[i] = tmp;
            }

            StringBuffer sb = new StringBuffer();
            boolean flag = false;
            for(int i = 0; i < n + m; i++){
                if(res[i] == 0 && flag == false){
                    continue;
                }else{
                    flag = true;
                    sb.append(res[i]);
                }
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}
