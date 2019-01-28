import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

public class Trie208 {


    class TrieNode{
        public boolean isWord;
        public TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }

    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            int index = (int)(word.charAt(i) - 'a');
            if(p.children[index] == null){
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
        }
        p.isWord = true;


    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = find(word);
        if(p != null && p.isWord == true){
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = find(prefix);
        if(p != null)
            return true;
        return false;

    }

    public TrieNode find(String word){
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++){
            if(p.children[word.charAt(i) - 'a'] == null)
                return null;
            p = p.children[word.charAt(i) - 'a'];
        }
        return p;
    }

}
