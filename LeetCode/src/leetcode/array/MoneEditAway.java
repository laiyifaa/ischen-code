package leetcode.array;

public class MoneEditAway {
    //面试题(程序员面试金典) 01.05. 一次编辑
    public boolean oneEditAway(String first, String second) {
        if(null == first || null == second)
            return false;
        int l1 = first.length();
        int l2 = second.length();
        int cnt = 0;
        int index = -1;
        if(l1 == l2){
            for(int i = 0;i < l1;++i){
                if(first.charAt(i) == second.charAt(i))
                    continue;
                ++cnt;
                if(cnt > 1)
                    return false;
            }
            if(cnt <= 1)
                return true;
        }else if(l1 + 1 == l2){
            index = l2-1;
            index = getTemp(first,second,index);
            for(int i = 0,j = 0; i < l2;++i,++j){
                if(i == index){
                    --j;
                    continue;
                }
                if(first.charAt(j) != second.charAt(i))
                    return false;
            }
            return true;
        }else if(l2 + 1 == l1) {
            index = l1-1;
            index = getTemp(second,first,index);
            for(int i = 0,j = 0; i < l1;++i,++j){
                if(i == index){
                    --j;
                    continue;
                }
                if(second.charAt(j) != first.charAt(i))
                    return false;
            }
            return true;
        }
        return false;
    }
    private Integer getTemp(String a,String b,int index){
        for(int i = 0; i < a.length();++i){
            if(a.charAt(i) != b.charAt(i)){
                index = i;
                break;
            }
        }
        return index;
    }
    public static void main(String[] args){  
        MoneEditAway q = new MoneEditAway();

        System.out.println(q.oneEditAway(
                "horse",
                "ros"
        ));
    }
}
