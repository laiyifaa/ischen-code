package leetcode.stack;

import java.util.LinkedList;

public class MIsChen_predictPartyVictory {
    //649. Dota2 参议院 循环队列
    //禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失 所有的权利 。(关键-这一轮和随后的几轮)
    //宣布胜利：如果参议员发现有权利投票的参议员都是 同一个阵营的 ，他可以宣布胜利并决定在游戏中的有关变化。
    public String predictPartyVictory(String senate) {
        if(null == senate || senate.length() == 0)
            return "";
        LinkedList<Integer> rQueue = new LinkedList<>();
        LinkedList<Integer> dQueue = new LinkedList<>();
        for(int i = 0; i < senate.length();++i){
            char c = senate.charAt(i);
            if(c == 'R')
                rQueue.addLast(i);
            else dQueue.addLast(i);
        }
        while (true){
            if(rQueue.isEmpty() || dQueue.isEmpty())
                break;
            int r = rQueue.pollFirst();
            int d = dQueue.pollFirst();
            if(r < d){
                rQueue.addLast(r + senate.length());
            }else {
                dQueue.addLast(d + senate.length());
            }
        }
        return rQueue.isEmpty()?"Dire":"Radiant";
    }
    public static void main(String[] args){
        MIsChen_predictPartyVictory q = new MIsChen_predictPartyVictory();
        System.out.println(
                q.predictPartyVictory("DDRRR")
        );
    }
}
