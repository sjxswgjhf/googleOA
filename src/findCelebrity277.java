import java.util.LinkedList;
import java.util.Queue;

public class findCelebrity277 {

    boolean knows(int a, int b){
        return true;
    }
    public int findCelebrity(int n) {
        int cele = 1;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 2; i <= n; i++){
            if(knows(1, i) == true){
                q.add(i);
            }
        }
        if(q.size() == 0)
            return cele;
        while(q.size() > 0){
            int size = q.size();
            cele = q.poll();
            while(size > 0){
                int person = q.poll();
                if(knows(cele, person) == true){
                    q.offer(person);
                }
                size--;
            }
        }
        return cele;
    }

}
