import java.util.*;

public class AutocompleteSystem642 {


    HashMap<String, Integer> map;
    StringBuffer sb;

    class Pair{
        String str;
        int freq;
        Pair(String s, int v){
            this.str = s;
            this.freq = v;
        }
    }
    public AutocompleteSystem642(String[] sentences, int[] times) {
        sb = new StringBuffer();
        map = new HashMap<>();
        for(int i = 0; i < sentences.length; i++){
            map.put(sentences[i], times[i]);
        }

    }

    public List<String> input(char c) {
        String str = new String();
        boolean flag = false;
        List<String> res = new ArrayList<>();
        if(c == '#'){
            str = sb.toString();
            sb = new StringBuffer();
            map.put(str, map.getOrDefault(str, 0) + 1);
            return res;
        }
        else{
            str = sb.append(c).toString();
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.freq == b.freq ? a.str.compareTo(b.str) : b.freq-a.freq));

        for(Map.Entry s : map.entrySet()){
            String  t= (String)s.getKey();
            if (t.startsWith(str)){
                pq.offer(new Pair((String)s.getKey(), (int)s.getValue()));
            }
        }

        while(!pq.isEmpty() && res.size() < 3){
            res.add(pq.poll().str);
        }

        pq.clear();
        return res;
    }


}
