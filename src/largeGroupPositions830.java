import java.util.LinkedList;
import java.util.List;

public class largeGroupPositions830 {



    public List<List<Integer>> largeGroupPositions830(String s) {
        List<List<Integer>> res=new LinkedList<>();
        if(s==null || s.length()<3){
            return res;
        }
        int count=1;
        char cur=s.charAt(0);
        int startIndex=0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)!=cur){
                if(count>=3){
                    List<Integer> list=new LinkedList<>();
                    list.add(startIndex);
                    list.add(startIndex+count-1);
                    res.add(list);
                }
                startIndex=i;
                count=1;
                cur=s.charAt(i);
            }else{
                count++;
            }
        }
        if(count>=3){
            List<Integer> list=new LinkedList<>();
            list.add(startIndex);
            list.add(startIndex+count-1);
            res.add(list);
        }
        return res;
    }

}
