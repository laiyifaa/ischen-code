package leetcode.stack;

import java.util.LinkedList;

public class MsimplifyPath {
    //71. 简化路径
    public String simplifyPath(String path) {
        if(null == path || path.length() == 0)
            return path;
        if("/".equals(path))
            return path;
        LinkedList<String> stack = new LinkedList<>();
        stack.addFirst("/");
        path = path + "/";
        int l = 1;
        for(int i = 1;i < path.length();){
            char c = path.charAt(i);
            char v = path.charAt(i - 1);
            if(c == '.' && v == '/'){
                int cnt = 1;
                int j = i + 1;
                while (j < path.length() && path.charAt(j) == '.'){
                    ++cnt;
                    ++j;
                }
                if(path.charAt(j) == '/'){
                    if(cnt <= 2){
                        l = j;
                    }
                    if(cnt == 2 && stack.size() > 1)
                        stack.pollLast();
                    i = j;
                    continue;
                }
            }
            if(c == '/'){
                String temp = path.substring(l, i);
                if(temp.length()  > 0 && !"/".equals(temp)){
                    stack.addLast(temp);
                }
                l = i + 1;
            }
            ++i;
        }
        StringBuilder ans = new StringBuilder(stack.pollFirst());
        if(stack.isEmpty())
            return ans.toString();
        while (!stack.isEmpty()){
            String cur = stack.pollFirst();
            ans.append(cur);
            ans.append("/");
        }
        ans.delete(ans.length() - 1,ans.length());
        return ans.toString();
    }
    public static void main(String[] args){  
      MsimplifyPath q = new MsimplifyPath();
      System.out.println(q.simplifyPath("/..hidden"));
    }
}
