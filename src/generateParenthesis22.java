import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class generateParenthesis22 {





    public static List<String> generateParenthesis(int n) {

        List<String> res=new LinkedList<>();
        if(n==0)
            return res;
        backtrack(n, res, new String(), 0, 0 );
        return res;
    }

    private static void backtrack(int n, List<String> res, String str, int open, int close){
//        System.out.println(str);
        if(str.length()==n*2){
            res.add(str);
            return;
        }
        if(open<n){
            backtrack(n, res, str+"(", open+1, close);
        }
        if(close<open){
            backtrack(n, res, str+")",open,close+1);
        }

    }


    public static void main(String[] args) {
        int n=3;
        generateParenthesis(n);
    }
}
