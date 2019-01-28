import java.util.Arrays;
import java.util.Map;

public class storeAndHouse {

    public static int[] storeAndHouse(int[] houses, int[] stores){

        int[] res=new int[houses.length];
        int m=houses.length;
        int n=stores.length;
        Arrays.sort(stores);
        int index=0;
        for(int h:houses){
            int closestStore=findStore(h, stores, n-1);
            res[index]=closestStore;
            index++;
        }
        return res;
    }

    public static int findStore(int value, int[] a, int len) {

        if(value < a[0]) {
            return a[0];
        }
        if(value > a[len]) {
            return a[len];
        }

        int lo = 0;
        int hi = len;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (value < a[mid]) {
                hi = mid - 1;
            } else if (value > a[mid]) {
                lo = mid + 1;
            } else {
                return a[mid];
            }
        }
        // lo == hi + 1
        return Math.abs(a[lo] - value) < Math.abs(value - a[hi]) ? a[lo] : a[hi];
    }


    public static void main(String[] args) {
        int[] stores = {1, 5, 20, 11, 16};
        int[] houses = {5, 10, 17};
        int[] res = storeAndHouse(houses, stores);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
