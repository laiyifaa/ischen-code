package leetcode.recall;

public class MpatternMatching {
    char[] chars;
    int aCount;
    int bCount;
    //面试题 16.18. 模式匹配
    public boolean patternMatching(String pattern, String value) {
        aCount = 0;
        bCount = 0;
        pattern = getPattern(pattern);
        //存在有一个为0
        if(aCount * bCount == 0 && value.length() == 0 )
            return true;
        if(aCount == 1 || bCount == 1)
            return value.length() != 0;
        chars = pattern.toCharArray();
          if(aCount > 0 && check(value.substring(0,value.length()/aCount),"",value) )
            return true;
        if(bCount > 0 && check("",value.substring(value.length()/bCount),value) ){
            return true;
        }
        int wordLen = getWordLen(value,aCount,bCount);
        for(int i = 0 ; i <= wordLen; ++i){
            String a = value.substring(0,i);
            int bStar = getBstar(a);
            if(bStar >= value.length())
                return check(a,"",value);
             for(int j = bStar ;j <= bStar + wordLen && j <= value.length();++j){
                String b = value.substring(bStar,j);
                      if( check(a,b,value))
                    return true;
            }
        }
        return false;
    }
    private int getWordLen(String value, int aCount, int bCount) {
        if (bCount == 0)
            return value.length()/aCount;
        if (aCount == 0)
            return value.length()/bCount;
        return  Math.max(value.length()/aCount,value.length()/bCount);
    }
    private int getBstar(String a) {
        int index = 0;
        for(char c : chars){
            if(c == 'a')
                index += a.length();
            else return index;
        }
        return index;
    }
    private String getPattern(String pattern) {
        chars = pattern.toCharArray();
        if(pattern.charAt(0) == 'b'){
            StringBuilder temp = new StringBuilder();
            for(char c : chars){
                if(c == 'b'){
                    ++aCount;
                    temp.append('a');
                }
                else {
                    ++bCount;
                    temp.append('b');
                }
            }
            return temp.toString();
        }
        for(char c : chars){
            if(c == 'a')
                ++aCount;
            else ++bCount;
        }
        return pattern;
    }
    private boolean  check(String a, String b, String value) {
        if(a.equals(b))
            return false;
        char[] patternChars = chars;
        int index = 0;
        for(char c : patternChars){
            if(c == 'a' && a.length() > 0){
                if(index + a .length() > value.length())
                    return false;
                String temp = value.substring(index,index + a.length() );
                if(temp.equals(a))
                    index+=a.length();
                else return false;
                continue;
            }
            if(c == 'b' && b.length() > 0){
                if(index + b.length() > value.length())
                    return false;
                String temp = value.substring(index,index + b.length() );
                if(temp.equals(b))
                    index+=b.length();
                else return false;
            }
        }
        return index == value.length() ? true : false;
    }
    public static void main(String[] args){
        MpatternMatching q = new MpatternMatching();
        System.out.println(  q.patternMatching("baabab","eimmieimmieeimmiee"));
    }
}
