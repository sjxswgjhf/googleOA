import java.util.*;

public class canFinish207 {


    /*
    9ms
    O(n)
     */

    public boolean canFinishTP(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList> map = new HashMap<>();
        for(int[] request : prerequisites){
            ArrayList<Integer> list = map.getOrDefault(request[0], new ArrayList<Integer>());
            list.add(request[1]);
            map.put(request[0], list);
        }
        boolean res = false;
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            res = dfs(map, i, visited);
            if(res == true){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(HashMap<Integer, ArrayList> map, int course, int[] visited){
        if(visited[course] == 1)
            return true;
        if(visited[course] == 2)
            return false;
        visited[course] = 1;
        ArrayList<Integer> list = map.get(course);
        if(list != null){
            for(int next : list){
                if(dfs(map, next, visited))
                    return true;
            }
        }

        visited[course] = 2;
        return false;
    }


    /*
    182ms
    O(n^2)
     */

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList> map = new HashMap<>();

        for(int[] request : prerequisites){
            ArrayList<Integer> list = map.getOrDefault(request[0], new ArrayList<Integer>());
            list.add(request[1]);
            map.put(request[0], list);
        }
        boolean res = false;
        for(int i = 0; i < numCourses; i++){
            Set<Integer> visited = new HashSet<>();
            res = bfs(map, i, visited);
            if(res == true){
                return false;
            }
        }

        return true;
    }

    private boolean bfs(HashMap<Integer, ArrayList> map, int course, Set<Integer> visited){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(course);
        visited.add(course);
        if(!map.containsKey(course)){
            return false;
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int c = queue.poll();
                ArrayList<Integer> list = map.get(c);
                if(list == null){
                    return false;
                }

                for(int cour : list){
                    if(visited.contains(cour)){
                        return true;
                    }
                    queue.add(cour);
                }
                size--;
            }
        }
        return false;
    }


}
