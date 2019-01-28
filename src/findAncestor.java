public class findAncestor {

    public static int[] findAncestor(int d, int[] A){

        int[] res=new int[A.length];
        for(int i=0; i<A.length; i++){
            int ancestor=dfs(d,A,i);
            res[i]=ancestor;
        }
        return res;
    }

    private static int dfs(int d, int[] A, int index){

        if(d==1){
            return A[index];
        }
        if(A[index]==-1)
            return -1;
        return dfs(d-1,A,A[index]);
    }

    public static void main(String[] args) {
        int[] A={-1,0,4,2,1};
        int d=3;
        int[] res=findAncestor(d,A);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
