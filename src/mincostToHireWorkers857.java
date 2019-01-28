import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class mincostToHireWorkers857 {


    /*
    两个条件： 最后的工资是按总quality*ratio算的
    那么为了满足每个人的exception：只有当ratio在k个人中最大的时候，那么每个人的exception会被满足
    那么先去计算每个人的wage/quailty并排序，然后去计算k个人的总工资，因为是要min，在loop的时候，我们需要去
    累加quality，并且当超过k的时候，我们需要减掉最高quality那个人并新加进去那人的ratio去比较当前res，
    这里我们需要一个maxheap去维护，priorityqueue的reverseOrder就是一个maxheap，那么我们用priorityqueue去记录每个
    算过的quality，当大于k的时候poll出来的第一个值就是最大的那个quality。

     */


    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[quality.length][2];
        for(int i=0; i<workers.length; i++){
            workers[i][0]=wage[i]*1.0/quality[i];
            workers[i][1]=quality[i];
        }
        //sort double array
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double res=Integer.MAX_VALUE;
        double curQua=0;
        for(double[] worker : workers){
            curQua+=worker[1];
            pq.add(worker[1]);
            if(pq.size()>K){
                curQua-=pq.poll();
            }
            if(pq.size()==K){
                res = Math.min(res, curQua*worker[0]);
            }
        }
        return res;

    }


}
