public class findRedundantConnection684 {

    class UnionFind{
        int[] parents;
        int[] ranks;
        public UnionFind(int n){
            parents = new int[n + 1];
            ranks = new int[n + 1];
            for(int i = 1; i <= n; i++){
                parents[i] = i;
                ranks[i] = 1;
            }
        }

        public boolean union(int u, int v){
            int parentU = findParent(u);
            int parentV = findParent(v);
            if(parentU == parentV){
                return false;
            }
            if(ranks[parentU] > ranks[parentV]){
                parents[parentV] = parentU;
            }
            else if(ranks[parentV] > ranks[parentU]){
                parents[parentU] = parentV;
            }else{
                parents[parentV] = parentU;
            }
            return true;
        }

        public int findParent(int u){
            while(u != parents[u]){
                parents[u] = parents[parents[u]];
                u = parents[u];
            }
            return u;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge : edges){
            int v = edge[0];
            int u = edge[1];
            if(!uf.union(u,v)){
                return edge;
            }
        }
        return new int[2];
    }
}
