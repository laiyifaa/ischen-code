package leetcode.array;

import java.util.LinkedList;
import java.util.List;

public class HfullJustify {

    private int maxLen = 0;
    //68. 文本左右对齐
    public List<String> fullJustify(String[] words, int maxWidth) {
        if(maxWidth < 1 || maxWidth > 100 || null == words || words.length == 0)
            return new LinkedList<>();
        List<String> ansList = new LinkedList<>();
        int curLen = 0;
        int l = -1;
        int r = -1;
        maxLen = maxWidth;
        for(int i = 0; i < words.length; ){
            l  = i;
            r = i;
            while (r < words.length){
                String s = words[r];
                curLen = curLen + s.length() ;
                int value = curLen  + r - l;
                if( value == maxWidth){
                    ansList.add(generateRow(words,l,r,curLen));
                    curLen = 0;
                    ++r;
                    break;
                }else if(value > maxWidth){
                    ansList.add(generateRow(words,l,r - 1,curLen - s.length()));
                    curLen = 0;
                    break;
                }
                ++r;
            }
            i = r;
        }
        if(curLen != 0){
            StringBuilder temp = new StringBuilder();
            temp.append(words[l]);
            for(int i = l + 1;i < words.length;++i){
                temp.append(' ');
                temp.append(words[i]);
            }
            while (temp.length() < maxLen)
                temp.append(' ');
            ansList.add(temp.toString());
        }
        return ansList;
    }

    private String generateRow(String[] words, int l, int r,int curLen) {
        StringBuilder temp = new StringBuilder();
        temp.append(words[l]);
        if(curLen == maxLen){
            for(int i = l + 1;i <= r;++i){
                temp.append(' ');
                temp.append(words[i]);
            }
        }else {
            int blankCnt = 0;
            boolean avgFlag = true;
            int emptyCnt = maxLen - curLen;//4
            int wordCnt = r - l;//3
            if(l != r){
                blankCnt = emptyCnt / wordCnt;//1
                avgFlag = blankCnt * wordCnt == emptyCnt ? true : false;//false
            }
            for(int i = l + 1;i <= r;++i){
                for(int j = 0;j < blankCnt;++j){
                    --emptyCnt;
                    temp.append(' ');
                }
                if(!avgFlag){
                    --emptyCnt;
                    temp.append(' ');
                }
                temp.append(words[i]);
                --wordCnt;
                if(!avgFlag){
                    blankCnt = emptyCnt / wordCnt;// 2 /2
                    avgFlag = blankCnt * wordCnt == emptyCnt ? true : false;//true
                }
            }
        }
        while (temp.length() < maxLen)
            temp.append(' ');
        return temp.toString();
    }
    public static void main(String[] args){  
        HfullJustify q = new HfullJustify();
        List<String> list = q.fullJustify(new String[]{
                "The","important","thing","is","not","to","stop","questioning.","Curiosity","has","its","own","reason","for","existing."
        }, 17);
        for(String s : list){
            System.out.println(s);
        }
    }
}
