public class partitionList86 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }


    public static ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode guard1 = list1;
        ListNode guard2 = list2;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                list1.next = cur;
                list1 = list1.next;
            }else{
                list2.next = cur;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        list2.next = null;
        list1.next = guard2.next;
        return guard1.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = null;
        ListNode tmp = partition(head, 3);
        while( tmp !=null){
            System.out.print(tmp.val);
            tmp = tmp.next;
        }
    }
}
