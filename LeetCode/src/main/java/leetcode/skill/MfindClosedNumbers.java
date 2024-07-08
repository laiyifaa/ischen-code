package leetcode.skill;

public class MfindClosedNumbers {
    //面试题 05.04. 下一个数
    public int[] findClosedNumbers(int num) {
        int minx = -1;
        int maxy = -1;
        int cnt = getCnt(num);
        int top = (num << 1 ) < 0 ? Integer.MAX_VALUE:num<<1;
        if(num != Integer.MAX_VALUE){
            for(int i = num + 1;i <= top;++i){
                if(getCnt(i) == cnt){
                    maxy = i;
                    break;
                }
            }
        }
        if(num != Integer.MAX_VALUE){
            for(int i = num - 1;i >= Math.max(1,num >>1);--i){
                if(getCnt(i) == cnt){
                    minx = i;
                    break;
                }
            }
        }
        return new int[]{maxy,minx};
    }

    private int getCnt(int num) {
        int cnt = 0;
        while (num > 0){
            if((num & 1) == 1)
                ++cnt;
            num >>>=1;
        }
        return cnt;
    }
    public static void main(String[] args){
        MfindClosedNumbers q = new MfindClosedNumbers();
        int[] closedNumbers = q.findClosedNumbers(2147483647);
        System.out.println(closedNumbers[0]);
        System.out.println(closedNumbers[1]);
    }
}
