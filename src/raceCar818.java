import java.util.PriorityQueue;
import java.util.Scanner;

public class raceCar818 {


    private static int[][] m;
    public int racecar(int target) {
        if (m == null) {
            final int kMaxT = 10000;
            m = new int[kMaxT + 1][2];
            for (int t = 1; t <= kMaxT; ++t) {
                int n = (int)Math.ceil(Math.log(t + 1) / Math.log(2));
                if (1 << n == t + 1) {
                    m[t][0] = n;
                    m[t][1] = n + 1;
                    continue;
                }
                int l = (1 << n) - 1 - t;
                m[t][0] = n + 1 + Math.min(m[l][1], m[l][0] + 1);
                m[t][1] = n + 1 + Math.min(m[l][0], m[l][1] + 1);
                for (int i = 1; i < t; ++i)
                    for (int d = 0; d <= 1; d++)
                        m[t][d] = Math.min(m[t][d], Math.min(
                                m[i][0] + 2 + m[t - i][d],
                                m[i][1] + 1 + m[t - i][d]));
            }
        }
        return Math.min(m[target][0], m[target][1]);

    }

}
