public class longestUnivaluePath687 {

    class TreeNode{
        int val;
        TreeNode right, left;
        TreeNode(int x){
            val = x;
        }
    }


    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return max;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int pl = 0;
        int pr = 0;
        if(root.left != null && root.val == root.left.val){
            pl = left + 1;
        }
        if(root.right != null && root.val == root.right.val){
            pr = right + 1;
        }
        max = Math.max(max, pl + pr);
        return Math.max(pl, pr);
    }



}
