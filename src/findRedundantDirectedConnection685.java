public class findRedundantDirectedConnection685 {
    /*
    There are two cases for the tree structure to be invalid.
    1) A node having two parents;
       including corner case: e.g. [[4,2],[1,5],[5,2],[5,3],[2,4]]
    2) A circle exists

    1) Check whether there is a node having two parents.
        If so, store them as candidates A and B, and set the second edge invalid.
    2) Perform normal union find.
        If the tree is now valid
               simply return candidate B
        else if candidates not existing
               we find a circle, return current edge;
        else
               remove candidate A instead of B.
     */

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            if (root(parent, father) == child) {
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father;
        }
        return can2;
    }

    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
