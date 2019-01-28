import java.util.Stack;

public class longestValidParentheses32 {

    /*
    好题！
    这题用stack是很明显的，但是一开始就想到了pop跟push character，但是发现没发实现()(()这种判断，然后卡题了，看了下
    discussion，发现去记录(的index，没必要去记录无用的char信息，其实记录char是无意义的，但是当记录了index我们可以利用
    stack来实现对index的判断，当)并且stack已经空了，说明这个是个分割情况，更新左端点，后面的有效长度跟前面的分开了，
    但是当stack没空的时候，我们会有两种情况，一种是pop一次之后空了，即这个)能找到pair即长度等于右端点-左端点，
    当pop一次还没空，那说明我们有个无效的(，他分割了string，那么因为我们记录了这个index所以右端点-stack.peek()就行
     */

    class Solution {
        public int longestValidParentheses(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int max = 0;
            int j = -1;
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '('){
                    stack.push(i);
                }
                else{
                    if(s.charAt(i) == ')'){
                        if(stack.isEmpty()){
                            j = i;
                        }
                        else{
                            stack.pop();
                            if(stack.isEmpty()){
                                max = Math.max(max, i - j);
                            }
                            else{
                                max = Math.max(max, i - stack.peek());
                            }
                        }
                    }
                }
            }
            return max;
        }
    }
}
