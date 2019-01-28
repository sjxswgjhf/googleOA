public class peakIndexInMountainArray852 {


    public int peakIndexInMountainArray(int[] A) {
        int index=A.length-1;
        for(int i=0; i<A.length-1; i++){
            if(A[i]>A[i+1]){
                index=i;
                break;
            }
        }

        return index;
    }
}
