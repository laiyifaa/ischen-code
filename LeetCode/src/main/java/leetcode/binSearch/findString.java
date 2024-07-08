package leetcode.binSearch;

public class findString {
    //面试题 10.05. 稀疏数组搜索
    public int findString(String[] words, String s) {
        int l = 0;
        int r = words.length - 1;
        while (l <= r ){
            while (l <= r && words[l].length() == 0) ++l;
            while (l <= r && words[r].length() == 0) --r;
            if(l <= r){
                int mid = l + (r - l) / 2;
                while (mid <= r && words[mid].length() == 0) ++mid;
                int op = words[mid].compareTo(s);
                if(op == 0)
                    return mid;
                else if(op < 0 ) l = mid + 1;
                else  r = mid - 1;
            }
        }

        return -1;
    }
}
