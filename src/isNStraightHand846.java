import java.util.PriorityQueue;
import java.util.TreeMap;

public class isNStraightHand846 {

    /*
    Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.



Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
     */

    /*
    Brute Force: PriorityQueue

    [1,2,2,3,3,4,6,7,8]
    [T,T,F,T]
    [T,T,T]
     */
    public boolean isNStraightHandPQ(int[] hand, int W) {
        if(hand.length%W!=0){
            return false;
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i:hand){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int cur=queue.poll();
            for(int i=1; i<W; i++){
                if(queue.remove(cur+i)) {
                    continue;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    /*
    Brute Force: TreeMap
     */

    public boolean isNStraightHandTM(int[] hand, int W) {
        if(hand.length%W!=0){
            return false;
        }
        TreeMap<Integer, Integer> map=new TreeMap<>();
        for(int i:hand){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        while(!map.isEmpty()){
            int cur=map.firstKey();
            for(int j=1; j<W; j++){
                if(map.containsKey(cur+j)){
                    if(map.get(cur+j)==1){
                        map.remove(cur+j);
                    }else{
                        map.put(cur+j,map.get(cur+j)-1);
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
