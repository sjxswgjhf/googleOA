import java.util.HashMap;
import java.util.Random;

public class findFirstUnique {


    public static char findFirstUnique(String s){
        int[] tables = new int[26];
        for(int i = 0; i < s.length(); i++){
            tables[s.charAt(i) - 'a'] += 1;
        }
        int index = -1;
        for(int i = 0; i < s.length(); i++){
            if(tables[s.charAt(i) - 'a'] == 1){
                index = i;
                break;
            }
        }
        if(index == -1){
            return (char)new String().charAt(0);
        }
        return s.charAt(index);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        HashMap<Integer, Integer> map = new HashMap<>();

        String s = "google";
        System.out.println(findFirstUnique(s));
    }
}
