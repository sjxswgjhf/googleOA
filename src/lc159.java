import java.util.HashMap;

public class lc159 {

    /*
    Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
    Example 1:
    Input: "eceba"
    Output: 3
    Explanation: t is "ece" which its length is 3.
    Example 2:

    Input: "ccaabbb"
    Output: 5
    Explanation: t is "aabbb" which its length is 5.
     */

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null || s.length()==0)
            return 0;
        int l=0,r=0;
        int maxLen=0;
        HashMap<Character, Integer> map=new HashMap<>();
        while(r<s.length()){
            if(map.size()<=2){
                char c=s.charAt(r);
                map.put(c, r);
                r++;
            }
            if(map.size()>2){
                int leftMost=s.length();
                for(int i:map.values()){
                    leftMost=Math.min(i,leftMost);
                }
                char a=s.charAt(leftMost);
                map.remove(a);
                l=leftMost+1;
            }
            maxLen = Math.max(maxLen, r-l);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String s="ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }


}
