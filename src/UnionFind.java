import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class UnionFind {


    private int[] parents;
    private int[] ranks;

    public UnionFind(int n){
        parents = new int[n + 1];
        ranks = new int[n + 1];
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv){
            return false;
        }
        if(ranks[pu] > ranks[pv]){
            parents[pv] = pu;
        }
        else if(ranks[pv] > ranks[pu]){
            parents[pu] = pv;
        }
        else{
            parents[pv] = pu;
            ranks[pu]++;
        }
        return true;
    }

    public int find(int u){
        while(parents[u] != u){
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }



}


