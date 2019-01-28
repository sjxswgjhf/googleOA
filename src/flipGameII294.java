import java.util.HashMap;

public class flipGameII294 {

    /*
    backtracking:尝试所有可能，什么时候可以是true呢，当翻转后对方无法翻转！

     */


    public boolean canWin(String s){
        if(s == null || s.length() < 2){
            return false;
        }

        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+'){
                String t = s.substring(0, i) + "--" + s.substring(i + 2, s.length());
                if(!canWin(t)){
                    return true;
                }
            }
        }
        return false;
    }


    /*
    recursion with memory
     */
    public boolean canWinRM(String s){
        if(s == null || s.length() < 2){
            return false;
        }
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }

    private boolean helper(String s, HashMap<String, Boolean> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+'){
                String t = s.substring(0, i) + "--" + s.substring(i+2, s.length());
                if(!helper(t, map)){
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }


}
