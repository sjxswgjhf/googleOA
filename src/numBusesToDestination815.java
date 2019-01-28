import java.util.*;

public class numBusesToDestination815 {


    /*
    BFS with Graph

    先用hashmap去建立图像，车站是key，value是个ArrayList里面包含的是公交
    然后做bfs
    通过开始站，找到所有能到达这个站的bus，然后loop这个bus里面所有能到的车站并判断是不是有T，如果有T那么return，没有就
    往Queue里面加车站。每次loop一层就+1,避免重复计算需要一个set去记录已经访问过的bus
    [1,2,7] [3,6,7]
    S=1 T=6
    1->bus 1 -> 1,2,7, loop 2,7 -> 7->bus2->3,6 stop

    time complexity: O(m*n)
    space complexity: O(m*n)
     */


    public int numBusesToDestination(int[][] routes, int S, int T) {

       HashMap<Integer, ArrayList> map = new HashMap<>();
       Set<Integer> visited = new HashSet<>();
       int ret=0;
       if(S==T)
           return 0;
       for(int i=0; i<routes.length; i++){
           for(int j=0; j<routes[0].length; j++){
               ArrayList list = map.getOrDefault(routes[i][j], new ArrayList<>());
               list.add(i);
               map.put(routes[i][j], list);
           }
       }
       Queue<Integer> q=new LinkedList<>();
        q.offer(S);
        while(!q.isEmpty()){
            int size=q.size();
            ret++;
            for(int i=0; i<size; i++){
                int curStop = q.poll();
                ArrayList<Integer> buses = map.get(curStop);
                for(int busId : buses){
                    if(visited.contains(busId)) continue;
                    visited.add(busId);
                    for(int j=0; j<routes[busId].length; j++){
                        if(routes[busId][j]==T)
                            return ret;
                        q.offer(routes[busId][j]);
                    }
                }
            }
        }
        return -1;
    }

}
