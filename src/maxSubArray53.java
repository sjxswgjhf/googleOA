public class maxSubArray53 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int prevSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(prevSum < 0){
                prevSum = nums[i];
                if(prevSum > max){
                    max = prevSum;
                }
            }else{
                prevSum += nums[i];
                if(prevSum > max){
                    max = prevSum;
                }
            }
        }
        return max;
    }
}
