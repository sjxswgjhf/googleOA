import java.util.HashMap;

public class sameSequence {

    /*
    给 str1 和 str2，如果str1中的字符在str2里出现，需要和str2中的顺序一致，否则返回false
    str1="google", str2="gle" -> true.1point3acres网
    str1="google", str2="eagle" -> false
    第二个例子没写对，str2里没有重复字符
    str1="google", str2="eagl" -> false
    */

    public static boolean sameSequence(String s1, String s2){

        int prefix = -1;
        for(int i = 0; i < s1.length(); i++){

            char c = s1.charAt(i);
            if(s2.indexOf(c) == -1){
                continue;
            }else {
                int index = s2.indexOf(c);
                if (index >= prefix) {
                    prefix = index;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "google";
        String s2 = "egl";
        System.out.println(sameSequence(s1, s2));
    }
}
