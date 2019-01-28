import java.util.*;

public class findReplaceString833 {


    /*
    Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
    Output: "eeebffff"

    Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
    Output: "eeecd"
    */


    /*
    "vmokgggqzp"
    [3,5,1]
    ["kg","ggq","mo"]
    ["s","so","bfr"]

    Method 1: Time O(nlogn), space: O(n).

1). Use TreeMap to sort indexes: put the (indexes[i], i) pair into the map;
2). Iterate the TreeMap by reverse order, and hence avoid the change of the indices of the rest part of the original String S after each replace.
    */

    /*
    这个题的精髓在于从后面开始替换，不会影响前面的index，然后通过treemap或者priorityqueue来实现index的排序跟记录index
    需要index来获取sources跟targets
     */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        StringBuffer sb=new StringBuffer(S);
        TreeMap<Integer, Integer> tm=new TreeMap<>();
        for(int i=0; i<indexes.length; i++){
            tm.put(indexes[i],i);
        }
        for(int key : tm.descendingKeySet()){
            int i=tm.get(key);
            if(S.substring(indexes[i]).startsWith(sources[i])){
                sb.replace(indexes[i],indexes[i]+sources[i].length(),targets[i]);
            }
        }
        return sb.toString();
    }



    /*
    solution for sorted index...but the indexes in pro is unsorted........FUCK U
     */

    public String findReplaceStringSortedIndexes(String s, int[] indexes, String[] sources, String[] targets) {

        Queue<Character> queue=new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            queue.offer(s.charAt(i));
        }
        int count=0;
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<indexes.length; i++){
            int index=indexes[i];
            while(count<index){
                sb.append(queue.poll());
                count++;
            }
            StringBuffer tmpSB=new StringBuffer();
            while(index>=0){
                tmpSB.append(queue.poll());
                index--;
            }
            String pattern= sources[i];
            if(tmpSB.toString().equals(pattern)){
                sb.append(targets[i]);
                count+=pattern.length();
            }else{
                sb.append(tmpSB);
                count+=tmpSB.length();
            }
        }
        return sb.toString();
    }
}
