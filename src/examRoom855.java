import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class examRoom855 {


    class ExamRoom {

        int n;
        PriorityQueue<Interval> pq;
        class Interval{
            int l, r, dist;
            public Interval(int l, int r){
                this.l=l;
                this.r=r;
                if(l==-1){
                    dist=r;
                }
                else if(r==n){
                    dist=n-1-l;
                }else{
                    dist=Math.abs(l-r)/2;
                }
            }
        }

        public ExamRoom(int N) {
            //看两个dis是不是相等，不相等那么先大再小，相等就是看谁的l小
            pq=new PriorityQueue<>((a,b)->a.dist!=b.dist?b.dist-a.dist:a.l-b.l);
            this.n=N;
            pq.add(new Interval(-1,N));
        }

        public int seat() {
            int seat=0;
            Interval interval=pq.poll();
            if(interval.l==-1){
                seat=0;
            }
            else if(interval.r==n){
                seat=n-1;
            }
            else {
                seat=(interval.l+interval.r)/2;
            }
            pq.offer(new Interval(interval.l,seat));
            pq.offer(new Interval(seat, interval.r));
            return seat;
        }

        public void leave(int p) {
            Interval head=null, tail=null;
            List<Interval> list=new LinkedList<>(pq);
            for(Interval interval: list){
                if(interval.r==p){
                    head=interval;
                }
                if(interval.l==p){
                    tail=interval;
                }
                if(head!=null && tail!=null){
                    break;
                }
            }
            pq.remove(head);
            pq.remove(tail);
            pq.add(new Interval(head.l, tail.r));
        }
    }

}