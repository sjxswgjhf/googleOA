import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class email {


    public static List<List<String>> emailFix(String[] strs){

        HashMap<String, Integer> map=new HashMap<>();
        List<List<String>> res=new LinkedList<>();
        for(String s:strs){
            char[] cs=s.toCharArray();
            int index=0;
            StringBuffer sb=new StringBuffer();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='@'){
                    sb.append(s.substring(i, s.length()));
                    break;
                }
                else if(s.charAt(i)=='.'){
                    continue;
                }
                else if(s.charAt(i)=='+'){
                    int tmp=i;
                    while(s.charAt(tmp)!='@'){
                        tmp++;
                    }
                    sb.append(s.substring(tmp,s.length()));
                    break;
                }
                else{
                    sb.append(s.charAt(i));
                }
            }
            String newStr=sb.toString();
            if(map.containsKey(newStr)){
                index=map.get(newStr);
            }else{
                index=map.size();
                map.put(newStr, map.size());
                res.add(new LinkedList<>());
            }
            res.get(index).add(newStr);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs={"a.b@example.com","ab@example.com","dupli......cate@example.com","duplicate@example.com",
                "d.u.p.l.i.c.a.t.e@example.com", "duplicate@example.com","ab+work@example.com",
                "jiax...sx+sax@ma.com","...jiaxsx@ma.com"};

        List<List<String>> res=emailFix(strs);
        System.out.println(res.size());
//        for(List<String> list:res){
//            for(String s:list){
//                System.out.print(s+" ");
//            }
//            System.out.println();
//        }
    }
}
