import java.util.LinkedList;
import java.util.List;

public class leafSimilar872 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new LinkedList<>();
        List<Integer> leaf2 = new LinkedList<>();
        findleaf(root1, leaf1);
        findleaf(root2,leaf2);
        for(int i=0; i<leaf1.size(); i++){
            if(leaf1.get(i)!=leaf2.get(i)){
                return false;
            }
        }
        return true;
    }

    private void findleaf(TreeNode root, List<Integer> list){
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }
        if(root.left!=null){
            findleaf(root.left,list);
        }
        if(root.right!=null){
            findleaf(root.right,list);
        }
    }
}
