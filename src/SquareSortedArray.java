public class SquareSortedArray {



    /*
    Given a sorted array, return the squared array
     */

    public static int[] squareArray(int[] input){

        if(input == null || input.length == 0){
            return new int[0];
        }
        int[] ret = new int[input.length];
        int n = input.length;
        int left = bs(input, 0, n);
        int right = left + 1;
        int start = 0;
        while( left >=0 || right < n){
            if(left >= 0 && right < n){
                if(Math.pow(input[left],2) < Math.pow(input[right], 2)){
                    ret[start] = (int)Math.pow(input[left],2);
                    left--;
                }
                else if(Math.pow(input[left], 2) > Math.pow(input[right], 2)){
                    ret[start] = (int)Math.pow(input[right], 2);
                    right++;
                }else{
                    ret[start] = (int)Math.pow(input[left], 2);
                    left--;
                }
            }
            else if(right < n && left < 0){
                ret[start] = (int)Math.pow(input[right], 2);
                right++;
            }
            else if(left >=0 && right >= n){
                ret[start] = (int)Math.pow(input[left], 2);
                left--;
            }

            start++;
        }
        return ret;
    }

    private static int bs(int[] input, int l, int r){

        while(r - l >= 2){
            int mid = l + (r - l) / 2;
            if(input[mid] < 0 && input[mid+1] >= 0){
                return mid;
            }
            else if(input[mid] >= 0){
                r = mid;
            }
            else{
                l = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -2, 1, 2, 3};
        int[] res = squareArray(nums);



    }

}
