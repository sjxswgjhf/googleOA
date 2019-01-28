import java.util.List;

public class wordBreak139 {
    /*
    dp：
    这题是从0~i，然后看从0~j是不是true的话那么只要j~i在dict里面，那么0~i就是true了，
    O(n^2)
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
