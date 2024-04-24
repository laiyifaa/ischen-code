package javase.juc.thread.demo06;
import java.util.*;

public class Lottery {
    public static void main(String[] args) {
        // 定义词条数组
        String[] items = {"物理攻击力", "总伤害", "无视防御", "其他"};

        // 定义概率数组，与词条数组对应
        double[] probabilities = {0.0513, 0.0513, 0.1538, 0.7436};
        int cnt =  0;
        while (true){
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < 1000000;++i){
                ++cnt;

                // 进行抽奖
                String[] results = drawLottery(items, probabilities, 6);
                int aCnt = 0;
                for(String result : results){
                    if(result.contains("物理攻击力"))
                        ++aCnt;
                }
                if(aCnt > 1){
              /*      System.out.println("------第" + cnt + "次6角-------");
                    for (String result : results) {
                        System.out.println(result);
                    }*/
                    list.add(new Integer(cnt));
                    cnt = 0;

                }
            }
            Integer sum = 0;
            for(Integer x : list){
                sum +=x;
            }
            System.out.println(sum/list.size());
        }

    }

    // 抽奖函数
    public static String[] drawLottery(String[] items, double[] probabilities, int numItems) {
        String[] results = new String[numItems];
        Random rand = new Random();

        for (int i = 0; i < numItems; i++) {
            double randNum = rand.nextDouble(); // 生成0到1之间的随机数
            String temp = "";
            if(i== 0 || i == 3){
                temp = "顶";
            }
            if(i == 1 ||i == 4){
                double xrand = rand.nextDouble();
                if(xrand > 0.2){
                    temp = "次顶";
                }else {
                    temp = "顶";
                }
            }
            if(i == 2 || i == 5){
                double yrand = rand.nextDouble();
                if(yrand > 0.15){
                    temp = "次顶";
                }else {
                    temp = "顶";
                }
            }
            double cumulativeProbability = 0.0;
            for (int j = 0; j < items.length; j++) {
                cumulativeProbability += probabilities[j];
                if (randNum < cumulativeProbability) {
                    results[i] = items[j] + " | " + temp;
                    break;
                }
            }
        }

        return results;
    }
}
