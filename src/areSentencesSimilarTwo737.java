import java.util.*;

public class areSentencesSimilarTwo737 {





    public boolean areSentencesSimilarTwoUnionFind(String[] words1, String[] words2, String[][] pairs) {

        if(words1.length != words2.length){
            return false;
        }

        HashMap<String, String> hashmap = new HashMap<>();
        for(String[] pair : pairs){

            String word1 = pair[0];
            String word2 = pair[1];

            String p1 = findParent(word1, hashmap);
            String p2 = findParent(word2, hashmap);
            if(!p1.equals(p2)){
                hashmap.put(p1, p2);
            }

        }

        for(int i = 0; i < words1.length; i++){
            String p1 = findParent(words1[i], hashmap);
            String p2 = findParent(words2[i], hashmap);
            if(!p1.equals(p2)){
                return false;
            }
        }
        return true;
    }

    private String findParent(String str, HashMap<String, String> map){
        if(map.containsKey(str)){
            return findParent(map.get(str), map);
        }
        return str;
    }





    HashMap<String, ArrayList<String>> map = new HashMap<>();
    public boolean areSentencesSimilarTwoBFS(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length){
            return false;
        }


        for(String[] strs : pairs){
            String str1 = strs[0];
            String str2 = strs[1];
            ArrayList<String> list1 = map.getOrDefault(str1, new ArrayList<>());
            list1.add(str2);
            map.put(str1, list1);
            ArrayList<String> list2 = map.getOrDefault(str2, new ArrayList<>());
            list2.add(str1);
            map.put(str2, list2);

        }

        boolean res = false;
        for(int i = 0; i < words1.length; i++){
            String str1 = words1[i];
            String str2 = words2[i];
            Set<String> visited= new HashSet<>();
            res = bfs(str1, str2, visited);
            if(res == false)
                return false;
        }
        return true;
    }

    private boolean bfs(String str1, String str2, Set<String> visited){
        if(str1.equals(str2)){
            return true;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(str1);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                String tmp = queue.poll();

                ArrayList<String> list = map.get(tmp);
                if(list == null){
                    size--;
                    continue;
                }else{
                    for(String str : list){
                        if(visited.contains(str)){
                            continue;
                        }
                        visited.add(str);
                        if(str.equals(str2)){
                            return true;
                        }else{
                            queue.add(str);
                        }
                    }
                    size--;
                }
            }
        }
        return false;
    }
}