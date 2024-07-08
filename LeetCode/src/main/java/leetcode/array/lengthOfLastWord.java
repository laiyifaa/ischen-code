package leetcode.array;

public class lengthOfLastWord {

    //58. 最后一个单词的长度
    public int lengthOfLastWord(String s) {
        if(null == s || s.length() == 0)
            return 0;
        int n = s.length() - 1;
        int ans = 0;
        while (n>=0){
            char c = s.charAt(n);
            if(c == ' '){
               if(ans == 0){
                   --n;
                   continue;
               }else {
                   break;
               }
            }
            if(c != ' '){
                ++ans;
                --n;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        lengthOfLastWord q = new lengthOfLastWord();
        System.out.println(q.lengthOfLastWord("Hello World"));
    }
}
