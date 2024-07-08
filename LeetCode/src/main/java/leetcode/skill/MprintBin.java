package leetcode.skill;

public class MprintBin {
    //面试题 05.02. 二进制数转字符串
    public String printBin(double num) {
        StringBuilder temp = new StringBuilder("0.");
        while (temp.length() <= 32 && num > 0){
            num*=2;
            if(num >= 1){
                temp.append("1");
                num-=1;
            }else {
                temp.append("0");
            }
        }
        return temp.length() < 32 ? temp.toString():"ERROR";
    }
    public static void main(String[] args){
        MprintBin q = new MprintBin();
        System.out.println(q.printBin(0.625));
    }
}
