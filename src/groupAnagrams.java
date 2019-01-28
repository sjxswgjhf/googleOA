import java.util.LinkedList;
import java.util.List;

public class groupAnagrams {
    /*
    这道题自己太搞笑了，以为自己写的是个O(N)的算法，跑完发现比O(klogk*N)的慢好多，想了半天没明白，最后发现自己其实写的是
    O(n^2)的算法。。。。失了智
    这题解题思路很简单其实我也想到了，但是以为自己可以用个boolean写个O(N)的算法写了后发现慢哭
    用hashmap跟sort来实现。先sort单词，然后再跟hashmap比较，如果是anag那么就会是一样，所以加入原来的str就好了

     */


        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new LinkedList<>();
            if(strs == null || strs.length == 0){
                return res;
            }
            boolean[] visited = new boolean[strs.length];
            // int[] freq = new int[26];
            int start = 0;
            while(start < strs.length){
                if(visited[start] == false){
                    List<String> list = new LinkedList<>();
                    int[] freq = new int[26];
                    String curStr = strs[start];
                    list.add(curStr);
                    for(int i = 0 ; i < curStr.length(); i++){
                        freq[curStr.charAt(i) - 'a']++;
                    }
                    for(int i = start + 1; i < strs.length; i++){
                        if(visited[i] == true){
                            continue;
                        }else{
                            String tmpStr = strs[i];
                            if(tmpStr.length() != curStr.length()){
                                continue;
                            }
                            int[] tmpFreq = new int[26];
                            for(int z = 0; z < 26; z++){
                                tmpFreq[z] = freq[z];
                            }
                            boolean isAnag = true;
                            for(int j = 0; j < tmpStr.length(); j++){
                                tmpFreq[tmpStr.charAt(j) - 'a']--;
                            }
                            for(int z = 0; z < 26; z++){
                                if(tmpFreq[z] != 0){
                                    isAnag = false;
                                    break;
                                }
                            }
                            if(isAnag == true){
                                list.add(tmpStr);
                                visited[i] = true;
                            }
                        }
                    }
                    if(list.size()!=0){
                        res.add(list);
                    }
                }
                start++;
            }
            return res;
        }

}
