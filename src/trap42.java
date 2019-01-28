import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class trap42 {

    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it is able to trap after raining.

    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
     */

    /*
    这题思路讲解：因为储水量是根据左右挡板的高度来决定的，那么当我知道左右挡板的最低高度并且知道当前高度，我就能知道我这个位置
    到底能储存多少水了，所以通过遍历左右挡板各个位置最高高度并且取当前位置最小高度，然后跟当前高度算差值，求得当前单位
    储水量，累计之后得到所有储水量，因为当前位置左右挡板是遍历之后求得的min在max中，所以不会有当前挡板高度超过左右挡板高度的
    问题。。
    这个dp虽然耗费了n的space，但是是最好理解思路也是interview中能解释清楚的思路，
    傻逼two pointer确实节省了空间，但是思路是很难理解并且解释的，看了一堆讲解跟思路说明，都是说不清楚。
    http://www.cnblogs.com/grandyang/p/4402392.html这个网站说的很清楚用dp思路
     */

    public int trap(int[] height) {

        int n = height.length;
        int[] ldp = new int[n];
        int[] rdp = new int[n];
        int[] dp = new int[n];
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        for(int i = 0; i < n; i++){
            leftMax = Math.max(leftMax, height[i]);
            ldp[i] = leftMax;
        }

        for(int i = n-1; i >= 0; i--){
            rightMax = Math.max(rightMax,height[i]);
            rdp[i] = rightMax;
        }

        for(int i = 0 ; i < n; i++){
            dp[i] = Math.min(ldp[i], rdp[i]);
            res += dp[i] - height[i];
        }
        return res;
    }
}
