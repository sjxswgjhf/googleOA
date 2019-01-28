import java.util.*;

public class distanceK863 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Method 1: use HashMap
//1. build a undirected graph using treenodes as vertices, and the parent-child relation as edges
//2. do BFS with source vertice (target) to find all vertices with distance K to it.

    Map<TreeNode, List<TreeNode>> map=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new LinkedList<>();
        if(root==null || k<0)
            return res;

        //build undirected graph
        buildMap(root, null);
        if(map.containsKey(target)==false)
            return res;

        //bfs
        Queue<TreeNode> q=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        q.add(target);
        visited.add(target);
        while(!q.isEmpty()){
            int size=q.size();
            if(k==0){
                for(int i=0; i<size; i++){
                    res.add(q.poll().val);
                }
                return res;
            }
            for(int i=0; i<size; i++){
                TreeNode node=q.poll();
               for(TreeNode next:map.get(node)){
                   if(visited.contains(next))
                       continue;
                   visited.add(next);
                   q.add(next);
               }
            }
            k--;
        }
        return res;
    }


    private void buildMap(TreeNode node, TreeNode parent){
        if(node==null){
            return;
        }
        if(!map.containsKey(node)) {
            map.put(node, new LinkedList<>());
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }


}