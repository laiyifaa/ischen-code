package leetcode.child_string;

public class MvalidIPAddress {


    String[] ans = new String[]{
            "IPv4","IPv6","Neither"
    };
    //468.验证IP地址
    public String validIPAddress(String queryIP) {
        if(null == queryIP || "".equals(queryIP))
            return ans[2];
        if(checkIPv4(queryIP))
            return ans[0];
        if(checkIPv6(queryIP))
            return ans[1];
        return ans[2];
    }

    private boolean checkIPv6(String queryIP) {
        queryIP = queryIP + ":";
        char[] chars = queryIP.toCharArray();
        int splitCount  = 0;
        int oldSplitIndex = -1;
        int curSplitIndex = -1;
        for(int i = 0;i < chars.length;++i){
            char c = chars[i];
            if(c == ':'){
                curSplitIndex = i;
                if(curSplitIndex - oldSplitIndex  < 2 || curSplitIndex - oldSplitIndex  > 5)
                    return false;
                ++splitCount;
                for(int j = oldSplitIndex + 1;j < curSplitIndex;++j){
                    char v = chars[j];
                    if((v >= '0' && v <='9' )|| (v>='A' &&v<='F') || (v >= 'a' && v<='f'))
                        continue;
                    return false;
                }
                oldSplitIndex = i;
            }
        }
        if(splitCount !=  8 || oldSplitIndex == -1)
            return false;
        return true;
    }
    private boolean checkIPv4(String queryIP) {
        queryIP = queryIP + ".";
        char[] chars = queryIP.toCharArray();
        int splitCount  = 0;
        int numLen = 0;
        int realNumLen = 0;
        int temp = 0;
        for(char c : chars){
            if(c == '.'){
                if(temp > 255){
                    return false;
                }
                ++splitCount;
                if(temp == 0)
                    ++realNumLen;
                while (temp > 0){
                    temp/=10;
                    ++realNumLen;
                }
                continue;
            }
            if(c >= '0' && c <= '9'){
                temp = temp * 10 + ( c - '0');
                ++numLen;
                continue;
            }
            return false;
        }
        if(splitCount != 4 || realNumLen != numLen)
            return false;
        return true;
    }
    public static void main(String[] args){
        MvalidIPAddress q = new MvalidIPAddress();
        System.out.println(
          q.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334")
        );
    }
}
