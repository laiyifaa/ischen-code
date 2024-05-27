package leetcode.skill;

public class MIsChen_rand10 {
    //470 用rand7()实现rand10()
    //(randX() - 1)*Y + randY() 可以等概率的生成[1, X * Y]范围的随机数
    public int rand10() {
        int num = (rand7() - 1) * 7 + rand7();
        while (num > 10){
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }
    private int rand7(){
        return 0;
    }
}
