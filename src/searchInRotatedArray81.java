public class searchInRotatedArray81 {

    /*
    binary search
     */

    public boolean search(int[] nums, int t){
        if(nums == null || nums.length == 0){
            return false;
        }
        int start = 0, end = nums.length;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == t){
                return true;
            }
            //start ... mid is sorted
            if(nums[mid] > nums[start]){
                if(t < nums[mid] && t > nums[start]){
                    end = mid;
                }else{
                    start = mid + 1;
                }
            }
            //mid -> end is sorted
            else if(nums[mid] < nums[start]){
                if(t > nums[mid] && t < nums[end]){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }
            else{
                start++;
            }
        }
        return false;
    }
}
