public class RLEIterator900 {

    class RLEIterator {

        int[] nums;
        int stopIndex;
        public RLEIterator(int[] A) {
            this.nums=A;
            stopIndex=0;
        }

        public int next(int n) {
            int res=0;
            for(int i=stopIndex; i<nums.length; i++){
                if(i%2==0){
                    if(nums[i]>0){
                        if(n>nums[i]){
                            n-=nums[i];
                            nums[i]=0;
                        }
                        else{
                            nums[i]=nums[i]-n;
                            stopIndex=i;
                            res=nums[i+1];
                            n=0;
                            break;
                        }
                    }
                }
            }
            if(n>0){
                return -1;
            }else{
                return res;
            }

        }
    }

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
}
