import java.util.*;

public class findFreq {

    public static int first(int arr[], int low, int high, int x, int n)
    {
        while(low < high){
            int mid = low + (high - low) / 2;
            if(arr[mid] >= x){      //upper bond  arr[mid] > x
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        if(arr[low] != x){
            return -1;
        }
        return low; // return index
    }

    /* if x is present in arr[] then returns the index of
    LAST occurrence of x in arr[0..n-1], otherwise
    returns -1 */


    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> res = new LinkedList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        int count = 0;
        for(Map.Entry me : map.entrySet()){
            pq.add(me);
        }
        while(res.size() < k){
            res.add(pq.poll().getKey());
        }
        return res;
    }

}
