import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class calcEquation399 {

    class Node {
        String c;
        double val;

        public Node(String c, double val) {
            this.val = val;
            this.c = c;
        }
    }

    HashMap<String, ArrayList> map = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //letter are key

        for (int i = 0; i < equations.length; i++) {
            String[] strs = equations[i];
            //length is 2
            String c1 = strs[0];
            String c2 = strs[1];

            ArrayList<Node> list1 = map.getOrDefault(c1, new ArrayList<>());
            Node node1 = new Node(c2, values[i]);
            list1.add(node1);
            map.put(c1, list1);

            ArrayList<Node> list2 = map.getOrDefault(c2, new ArrayList<>());
            Node node2 = new Node(c1, 1.0 / values[i]);
            list2.add(node2);
            map.put(c2, list2);

        }

        /*  a -> 2.0c
        *   b -> 3.0c
        */
        double[] res = new double[queries.length];
        int count = 0;
        for (String[] query : queries) {
            Set<String> visited = new HashSet<>();
            String c1 = query[0];
            String c2 = query[1];
            if (!map.containsKey(c1) || !map.containsKey(c2)) {
                res[count] = -1.0;
            } else {
                res[count] = dfs(c1, c2, visited);
            }
            count++;
        }
        return res;
    }

    private double dfs(String cur, String target, Set<String> visited) {
        if (target == cur) {
            return 1.0;
        }
        ArrayList<Node> list = map.get(cur);
        visited.add(cur);
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (visited.contains(node.c)) continue;
            double res = dfs(node.c, target, visited);
            if (res > -1.0) {
                return res * node.val;
            }
        }
        return -1.0;
    }
}
