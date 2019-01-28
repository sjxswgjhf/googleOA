public class gcf {



    public static int gcf(int a, int b, int gcf, int k){

        int bound=a<b?a:b;

        if(k>bound){
            return gcf;
        }
        else{

            if(a%k==0 && b%k==0){
                return gcf(a/k, b/k, gcf*k, 2);
            }
            else{
                return gcf(a, b, gcf, k+1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(gcf(120,60, 1, 2));
    }

}
