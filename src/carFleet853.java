import java.util.Collections;
import java.util.TreeMap;

public class carFleet853 {


    /*
    Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]

    position[10, 8, 5, 3, 0]
    speed   [2, 4, 1, 3, 1]     =>  time [1, 1, 7, 3, 12]

    解题思路：根据离终点的距离来sort之后并存上需要到终点的时间
    然后遍历，遇到要更久的那就carfleet++，更短的不需要做任何操作，因为会被前面的堵住
     */




    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map=new TreeMap<>();

        //sorted map by distance
        for(int i=0; i<position.length; i++){
            map.put(-position[i], (double) ((target-position[i])/speed[i]));
        }
        int res=0;
        double cur=-1;
        for(Double d:map.values()){
            if(d>cur){
                cur=d;
                res++;
            }
        }
        return res;
    }


}
