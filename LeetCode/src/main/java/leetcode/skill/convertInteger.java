package leetcode.skill;

public class convertInteger {
    //面试题 05.06. 整数转换
    public int convertInteger(int A, int B) {
        int flag =  A ^ B;
        if(flag == 0)
            return 0;
        else {
            int count = 0;
            while (flag != 0){
                if((flag&1) == 1)
                    count++;
                flag >>>=1;
            }
            return count;
        }
    }

}
