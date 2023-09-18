package leetcode.double_pointer;

import java.util.LinkedList;

public class Mcompress {

    private int change(char[] chars,int l,int temp ,char x){
        chars[l++] = x;
        if(temp == 1)
            return l;
        LinkedList<Integer> list = new LinkedList<>();
        while (temp > 0){
            list.addFirst(temp%10);
            temp/=10;
        }
        for(Integer y : list){
            chars[l++] = (char)(y + '0');
        }
        return l;
    }
    //443. 压缩字符串
    public int compress(char[] chars) {
      if(null == chars || chars.length == 0)
          return 0;
      if(chars.length == 1)
          return 1;
      char x = chars[0];
      int temp = 1;
      int len = 0;
      for(int i = 1;i<chars.length;++i){
          if(x == chars[i]){
              ++temp;
          }else {
            len = change(chars,len,temp,x);
            temp = 1;
            x = chars[i];
          }
      }
      len = change(chars,len,temp,x);
      if(len < chars.length){
          chars[len] = '\0';
      }
      return len;
    }
    public static void main(String[] args){  
        Mcompress q = new Mcompress();
        System.out.println(
                q.compress(new char[]{
                        'a','a',  'a','a',  'a','a',  'a','a',  'a','a'
                })
        );
    }
}
