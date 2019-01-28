import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
这题其实只有暴力破解，没有什么巧思，唯一取巧点是dictionary里面的单词都是统一长度的，然后tmd例子给了个不同长度的，逗我？
想用two pointer加hashmap来作，发现不同长度的时候无法做到控制左边指针，当长度相同的时候才能再这样子做。indea没有错，通过
两个hashmap来操作，一个记录words里面word出现的次数，一个记录遍历时候遇到的次数，当match的时候就match++，当match == 字典
长度的时候就去记录初始的index，但是要注意可能遇到重复的word，虽然次数增长了，但是并没有意义，所以检查是不是当前map的word
次数有没有超过dictionary的map的word的出现次数，一旦超过也就不符合了，重新回到i+1再开始遍历。时间复杂度其实是O(N*M),N为
s的长度，m是words的长度
总结：这题出的还行，但是给的例子都tmd在逗我？？？？？？？？
 */

public class findSubString30 {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new LinkedList<>();
            if(s == null || s.length() == 0 || words == null || words.length == 0){
                return res;
            }
            HashMap<String, Integer> map = new HashMap<>();
            for(String word: words){
                map.put(word, map.getOrDefault(word, 0)+1);
            }
            int n = words.length, len = words[0].length();
            for(int i = 0; i < s.length() - n * len +1; i++){
                Map<String, Integer> seen = new HashMap<>();
                int j = 0;
                while( j < n){
                    String word = s.substring(i + j*len, i + (j + 1) * len );
                    if (map.containsKey(word)) {
                        seen.put(word, seen.getOrDefault(word, 0) + 1);
                        if (seen.get(word) > map.getOrDefault(word, 0)) {
                            break;
                        }
                    } else {
                        break;
                    }
                    j++;
                }
                if (j == n) {
                    res.add(i);
                }
            }
            return res;
        }
    }
}
