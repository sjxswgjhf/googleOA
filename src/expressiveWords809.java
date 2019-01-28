public class expressiveWords809 {

    /*
    这题的思路就是拿s去跟每个word作对比，match了就res++，
    怎么作对比呢？有个限制就是长度要大于等于3才能缩减，也就是说当我们的一个char长度是1或者2的时候那么word里面这个char的当度
    也必须一样，1对应1，2对应2，不能不同，那么我们通过控制指针去走两个string，当遇到相同的时候就同时往后走一步，那么这时候不
    一样了的时候，s的char肯定是要大于等于三才能match，也就是要比较三个char，那么有三种情况，一种是开始（已经比较了）
    第二种是在中间的时候，那么这个char的范围肯定不能超过限制，并且要满足==i-1跟==i+1的情况，这样我们指针可以往后组，去
    检查第三种情况，即指针要满足限制条件，并且i==i-1，i==i-2，那么我们可以往后走了，最后还要判断当我们走完了，第二根指针
    是不是等于w的长度，可能有第一个单词：gooog 第二个单词：gogl 的情况，那么这种情况是不符合的，但是我们的s走的完，但是
    第二个指针指的却是w的lastindex，并没有走完w，所以不符合


     */


    public int expressiveWords809(String s, String[] words) {
        int res =0;
        for(String w : words){
            if(match(s, w)){
                res++;
            }
        }
        return res;
    }

    private boolean match(String s, String w){
        int m = s.length();
        int n = w.length();
        int r = 0;
        for(int i = 0; i < m; i++){
            if(s.charAt(i) == w.charAt(r)){
                r++;
            }
            else if(i>0 && i < m-1 && s.charAt(i) == s.charAt(i-1) && s.charAt(i) == s.charAt(i+1)){
                continue;
            }
            else if(i>1 && s.charAt(i) == s.charAt(i-1) && s.charAt(i-1) == s.charAt(i-2)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

}
