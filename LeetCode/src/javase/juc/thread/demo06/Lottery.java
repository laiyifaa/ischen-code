package javase.juc.demo.demo06;

import java.util.Random;
import java.util.Scanner;

import static org.omg.CORBA.ORB.init;

public class Lottery {
    // 定义物品的概率
    private static final double WUGONG_BAOZHU_PROBABILITY = 0.005;
    private static final double NUWUSHEN_ZHI_XIN_PROBABILITY = 0.004;
    private static final double QIHEI_SUIPIAN_PROBABILITY = 0.03;
    private static final double RUIZHI_HULU_PROBABILITY = 0.004;
    private static final double XINGLI_16_QIANGHUAJUAN_PROBABILITY = 0.008;

    static  int wCnt = 0;
    static  int nCnt = 0;
    public static void init(){
        wCnt = 0;
        nCnt = 0;
    }
    // 定义抽奖方法
    public static String drawLottery() {
        Random random = new Random();
        double randomNumber = random.nextDouble(); // 生成0到1之间的随机数

        if (randomNumber < WUGONG_BAOZHU_PROBABILITY) {
            ++wCnt;
            return "武功宝珠！！！！！！！";
        } else if (randomNumber < WUGONG_BAOZHU_PROBABILITY + NUWUSHEN_ZHI_XIN_PROBABILITY) {
            ++nCnt;
            return "女武神之心！！！！！！";
        } else if (randomNumber < WUGONG_BAOZHU_PROBABILITY + NUWUSHEN_ZHI_XIN_PROBABILITY + QIHEI_SUIPIAN_PROBABILITY) {
            return "漆黑碎片！！！！！";
        } else if (randomNumber < WUGONG_BAOZHU_PROBABILITY + NUWUSHEN_ZHI_XIN_PROBABILITY + QIHEI_SUIPIAN_PROBABILITY + RUIZHI_HULU_PROBABILITY) {
            return "睿智葫芦！！！";
        } else if (randomNumber <= WUGONG_BAOZHU_PROBABILITY + NUWUSHEN_ZHI_XIN_PROBABILITY + QIHEI_SUIPIAN_PROBABILITY + RUIZHI_HULU_PROBABILITY + XINGLI_16_QIANGHUAJUAN_PROBABILITY) {
            return "星力16强化卷！！！！";
        } else {
            return "没抽中";
        }
    }

    // 测试抽奖方法
    public static void main(String[] args) {
        int cnt = 0;
        while (true){
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            System.out.println("------第" + ++cnt + "组苹果-------");
            for(int j = 0;j < 1;++j){
                // 模拟进行10次抽奖
                for (int i = 0; i < 10; i++) {
                    String prize = drawLottery();
                    System.out.println("第" + (i + 1) + "次抽奖的结果是：" + prize);
                    if(prize.equals("武功宝珠！！！！！！！")){
                        System.out.println("武功:" + wCnt + "   女武神：" + nCnt) ;
                    }
                    if(prize.equals("女武神之心！！！！！！")){
                        System.out.println("武功:" + wCnt + "   女武神：" + nCnt) ;
                    }
                }
                if(cnt %10 == 0){
                    Random random = new Random();
                    double randomNumber = random.nextDouble(); // 生成0到1之间的随机数
                    if(0 < randomNumber &&  randomNumber < 0.1){
                        ++wCnt;
                        System.out.println("金宝箱：武功");
                    }else if(0.1 < randomNumber && randomNumber< 0.2 ){
                        ++nCnt;
                        System.out.println("金宝箱：女武神");
                    }else{
                        System.out.println("金宝箱：没抽中");
                    }
                    System.out.println("武功:" + wCnt + "   女武神：" + nCnt) ;
                }
            }
        }
    }
}
