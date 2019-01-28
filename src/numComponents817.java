import java.util.HashSet;
import java.util.Set;

public class numComponents817 {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set=new HashSet<>();
        for(int i=0; i<G.length; i++){
            set.add(G[i]);
        }
        int res=0;
        while(head!=null){
            if(set.contains(head.val) && !set.contains(head.next.val)){
                res++;
            }
        }
        return res;
    }

}
