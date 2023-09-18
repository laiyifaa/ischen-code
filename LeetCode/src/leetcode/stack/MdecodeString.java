package leetcode.stack;



public class MdecodeString {
    //394. 字符串解码
    public String decodeString(String s) {
        if(null == s || s.length() == 0)
            return s;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(checkMidBracket(c)){
                continue;
            }
            i = add(i,s,ans);
        }
        return ans.toString();
    }
    private int add(int i ,String s,StringBuilder ans){
        char c = s.charAt(i);
        if(checkNum(c)){
            int num = c - '0';
            int j = i + 1;
            while (checkNum(s.charAt(j))){
                num = num * 10 + s.charAt(j) - '0';
                ++j;
            }
            i = addString(ans,j+1,s,num);
        }else {
            ans.append(c);
        }
        return i;
    }
    private int addString(StringBuilder ans,int l,String s,int k){
        StringBuilder temp = new StringBuilder();
        int r = s.length();
        for(int i = l; i < s.length(); ++i){
            char c = s.charAt(i);
            if(checkMidBracket(c)){
                r = i;
                break;
            }
           i = add(i,s,temp);
        }
        for(int i = 0;i < k;++i){
            ans.append(temp);
        }
        return r;
    }

    private boolean checkNum(char c){
        if(c >='0' && c<='9')
            return true;
        return false;
    }
    private boolean checkMidBracket(char c){
        if( c ==']')
            return  true;
        return false;
    }
    public static void main(String[] args){  
        MdecodeString q = new MdecodeString();
        String s = "abc3[cd]xyz";
       System.out.println( q.decodeString(s));
    }
}
