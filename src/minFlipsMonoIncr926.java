public class minFlipsMonoIncr926 {

    //prefix + suffix
    public int minFlipsMonoIncr(String S) {
        //prefix + suffix sum
        //why need one more sapce?
        //because we need to loop find min from l[i-1] + r[i] which mean from left how much 1 -> 0, and from
        // right how much 0->1, when the end of S, l[S.length]+r[S.length+1] means all 1 to 0
        int[] l = new int[S.length()+1];
        int[] r = new int[S.length()+1];
        l[0] = S.charAt(0)-'0';
        r[S.length()-1] = '1' - S.charAt(S.length() - 1);
        for(int i = 1; i < S.length(); i++){
            l[i] = l[i-1] + S.charAt(i) - '0';
        }
        for(int i = S.length()-2; i >= 0; i--){
            r[i] = r[i + 1] + '1' - S.charAt(i);
        }
        // three thing need to comapre l[i-1]+r[i], l[S.length-1], r[0]
        int res = r[0]; //all 1 to 0 will be compare later in the loop, so here to use all 0 to 1
        for(int i = 1 ; i <= S.length(); i++){
            res = Math.min(l[i - 1] + r[i], res);
        }

        // for(int j : l){
        //     System.out.print(j+" ");
        // }
        // System.out.println();
        // for(int j : r){
        //     System.out.print(j+" ");
        // }
        // System.out.println();

        return res;
    }


}
