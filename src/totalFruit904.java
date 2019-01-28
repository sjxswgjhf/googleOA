import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class totalFruit904 {


    /*
    approach: sliding window solution
    O(n) time , O(n) space
     */

    public int totalFruit(int[] tree) {

        Map<Integer, Integer> map=new HashMap<>();

        int r=0,l=0;
        int max=0;



        while(r<tree.length){
            if(map.size()<=2){
                int val=tree[r];
                //val is the fruit id and r is index
                map.put(val,r);
                r++;
            }

            if(map.size()>2){
                int leftMost=tree.length;
                //find the leftmost fruit and remove it from map to add new fruit into map
                for(int i:map.values()){
                    leftMost=Math.min(leftMost, i);     //its index
                }
                int id=tree[leftMost];     //need key which is fruit index in map to remove
                map.remove(id);
                l=leftMost+1;       //update left pointer to the next fruit after the remove fruit
            }
            max=Math.max(max, r-l);     //update max in each step
        }
        return max;
    }



}
