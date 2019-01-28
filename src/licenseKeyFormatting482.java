public class licenseKeyFormatting482 {



    public String licenseKeyFormatting(String S, int K) {


        String s=S.replaceAll("-","");
        StringBuffer sb = new StringBuffer();
        int count=0;
        for(int i = s.length(); i >= 0; i--){
            if(count<K){
                sb.insert(0, Character.toUpperCase(s.charAt(i)));
                count++;
            }else{
                sb.insert(0, '-');
                count=0;
            }
        }
        return sb.toString();

    }


}
