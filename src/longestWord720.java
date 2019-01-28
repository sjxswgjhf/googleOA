import java.util.*;

public class longestWord720 {


    class Solution {

        public String longestWord(String[] words) {

            String res = new String();
            if (words == null || words.length == 0) {
                return res;
            }
            Set<String> set = new HashSet<>();
            for (String word : words) {
                set.add(word);
            }
            Arrays.sort(words, (a, b) -> (a.length() == b.length() ? a.compareTo(b) : b.length() - a.length()));

            for (String word : words) {
                boolean flag = false;
                for (int i = 0; i < word.length(); i++) {
                    if (set.contains(word.substring(0, i + 1))) {
                        flag = true;
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    res = word;
                    break;
                }
            }
            return res;
        }
    }


    //Trie Tree
    class Node{
        Node[] children = new Node[26];
        String word = "";
    }

    Node root = new Node();

    public String longestWord(String[] words) {
        for (String w: words) {
            insert(w);
        }
        return dfs(root, "");
    }

    private void insert(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new Node();
            }
            cur = cur.children[c-'a'];
        }
        cur.word = s;
    }

    private String dfs(Node node, String current) {
        if (node == null || node != root && node.word.length() == 0) return current;
        String res = node.word;
        for (Node next: node.children) {
            String nextWord = dfs(next, node.word);
            if (nextWord.length() > res.length()) {
                res = nextWord;
            }
        }
        return res;
    }
}
