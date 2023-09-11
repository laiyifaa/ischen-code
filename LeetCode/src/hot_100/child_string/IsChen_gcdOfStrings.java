package hot_100.child_string;

public class IsChen_gcdOfStrings {
    //1071. 字符串的最大公因子
    public String gcdOfStrings(String str1, String str2) {
        if(null == str1 || null == str2 || str1.length() == 0 || str2.length() == 0)
            return "";
        int l1 = str1.length();
        int l2 = str2.length();
        if(l1 == l2){
            return str1.equals(str2)?str1 :"";
        }else{
            int g = gcd(l1, l2);

            for(int i  = 0;i<g;i++){
                String temp = str1.substring(i,i+g);
                if(check(str1,g,temp) && check(str2,g,temp))
                    return temp;
            }
        }
        return "";
    }
    private boolean check(String s,int g,String temp){
        for(int i = 0 ;i<s.length();++i){
            if(s.charAt(i) != temp.charAt(i%g))
                return false;
        }
        return true;
    }
    private int  gcd(int a, int b){
        if(b==0){
            return a;}
        return gcd(b,a%b);
    }

}
