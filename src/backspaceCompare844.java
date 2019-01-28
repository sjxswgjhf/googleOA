import java.util.Stack;

public class backspaceCompare844 {

    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stack=new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        char[] chas=new char[stack.size()];
        while(!stack.isEmpty()){
            chas[stack.size()-1]=stack.pop();
        }
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i)=='#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(t.charAt(i));
            }
        }
        if(stack.size()!=chas.length){
            return false;
        }
        while(!stack.isEmpty()){
            if(chas[stack.size()-1]!=stack.pop()){
                return false;
            }
        }
        return true;
    }

    /*
    Better Answer: use back string compare, 但是操作起来其实挺麻烦的，当遇到#的时候我们要去记录我们会遇到几个，然后跳过这些个数的
    char，之后再比较，但是麻烦的是index要非常注意
     */
    public boolean backspaceCompareBetterAnswer(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int countS = 0;
        int countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (s.charAt(i) == '#' || countS > 0)) {
                if (s.charAt(i) == '#') {
                    countS++;
                } else {
                    countS--;
                }
                i--;
            }

            char charS = i < 0 ? '!' : s.charAt(i);

            while (j >= 0 && (t.charAt(j) == '#' || countT > 0)) {
                if (t.charAt(j) == '#') {
                    countT++;
                } else {
                    countT--;
                }
                j--;
            }

            char charT = j < 0 ? '!' : t.charAt(j);

            if (charS != charT) {
                return false;
            } else {
                i--;
                j--;
            }
        }
        return true;
    }
}
