public class firstMissingPositive41 {

    /*
    思考思路：题目要求是constant extra space,然后return第一个missing positive integer。
    这题其实跟电面题很像，只是这题是return第一个missing positive integer并且要constant space，而那题要排序
    一开始想到是O(klogk)的minheap来做，可是一看要求linear果断换方法，然后又想到了loop找最大值，然后建个int[]去标记
    index，虽然这个可以有效处理了dup的情况并且能linear找到答案，但是要求n space，在max很大但是input很小的时候
    这个方法就很傻逼了。想了半天没想到方法。看了discussion发现可以用input swap的方法来做，hard的题目果然要运用一切能
    运用的东西去求解啊，学到了
    解题方法：通过一个index来运作，遇到当前值是大于长度或者负数再或者本来就在正确位置的自动略过即index++，如果遇到不在正确
    位置的，因为这题有dup所以要先判断num[nums[i]]==num[i]，因为可能遇到[0,1,2,1,4]这种情况，在index=3的时候如果不加
    判断就会无限循环了，这是个circle，只有不相等才能swap，其他情况也都是index++，然后把index变成0，重新loop，如果遇到
    有nums[i]!=i+1的也就说明这个位置应该是我们缺失的第一个正整数！因为不缺失的话，在swap的时候会把这个数移动到当前正确
    的对应的位置！
    这样就做到了O(N) time跟O(1) space
     */



    class Solution {
        public int firstMissingPositive(int[] nums) {
            int i = 0;
            while( i < nums.length){
                if(nums[i] >= nums.length || nums[i] <= 0 || nums[i] == i + 1){
                    i++;
                }
                else if(nums[i] != nums[nums[i]-1]){
                    swap(nums, i, nums[i]);
                }
                else{
                    i++;
                }
            }
            i = 0;
            while(i < nums.length && nums[i] == i + 1){
                i++;
            }
            return i + 1;
        }

        private void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j - 1];
            nums[j - 1] = tmp;
        }
    }
}
