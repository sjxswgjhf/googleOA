public class buddyStrings859 {


    /*
    Given two strings A and B of lowercase letters, return true if and only if we can swap two letters
    in A so that the result equals B.
     */

    /*
    Brute Force: TLE
     */

    public boolean buddyStringsBF(String a, String b) {

        if(a.length()!=b.length()){
            return false;
        }
        char[] cs=a.toCharArray();
        for(int i=0; i<cs.length-1; i++){

            for(int j=i+1; j<cs.length; j++){
                char tmp=cs[i];
                cs[i]=cs[j];
                cs[j]=tmp;
                if(b.equals(new String(cs))){
                    return true;
                }else{
                    cs[j]=cs[i];
                    cs[i]=tmp;
                }
            }
        }
        return false;
    }


    /*
    Enumerate Cases:
    思路：首先处理两个string相同的情况，如果当每个char个数只有1的时候就是false
    然后处理不相同的情况： 分别记录两个不相同的位置，并记录dif的次数，只有dif等于2并且a.char(i)=b.char(j)&&a.char(j)=b.char(i)
     */
    public boolean buddyStrings(String a, String b) {
        if(a.length()!=b.length())
            return false;
        if(a.equals(b)){
            int[] chas=new int[26];
            for(int i=0;i<a.length(); i++){
                chas[a.charAt(i)-'a']++;
            }
            for(int i:chas) {
                if (i > 1) return true;
            }
            return false;
        }
        else{
            int first=-1, second=-1, dif=0;
            for(int i=0; i<a.length(); i++){
                if(a.charAt(i)!=b.charAt(i)){
                    if(first==-1){
                        first=i;
                    }
                    else{
                        second=i;
                    }
                    dif++;
                }
            }
            return dif==2 && a.charAt(first)==b.charAt(second) && a.charAt(second)==b.charAt(first);
        }
    }

}
