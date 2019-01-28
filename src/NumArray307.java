public class NumArray307 {



    class NumArray {

        class FenwickTree{
            int[] sums;
            public FenwickTree(int n){
                sums = new int[n + 1];
            }

            public void update(int i, int delate){
                while(i < sums.length){
                    sums[i] += delate;
                    i += i & -i;
                }
            }

            public int query(int i){
                int res = 0;
                while(i > 0){
                    res += sums[i];
                    i -= i & -i;
                }
                return res;
            }
        }

        FenwickTree tree;
        int[] nums;

        public NumArray(int[] nums) {
            tree = new FenwickTree(nums.length);
            this.nums = nums;
            for(int i = 0; i < nums.length; i++){
                tree.update(i+1, nums[i]);
            }
        }

        public void update(int i, int val) {
            tree.update(i+1, val-nums[i]);
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            int res = tree.query(j+1) - tree.query(i);
            return res;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

}
