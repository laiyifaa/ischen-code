package leetcode.stack;

import java.util.LinkedList;

public class MasteroidCollision {
    //735. 行星碰撞
    public int[] asteroidCollision(int[] asteroids) {
        if(null == asteroids || asteroids.length < 2)
            return new int[]{};
        LinkedList<Integer> rights = new LinkedList<>();
        LinkedList<Integer> lefts = new LinkedList<>();
        for(int i = 0;i < asteroids.length;++i){
            int temp = asteroids[i];
            if(temp > 0){
                lefts.addFirst(temp);
            }else {
                temp = -1 * temp;
                while (!lefts.isEmpty() && lefts.peekFirst() <  temp){
                    lefts.pollFirst();
                }
                if(!lefts.isEmpty()){
                    if(lefts.peekFirst() == temp){
                        lefts.pollFirst();
                    }
                    continue;
                }
                rights.addLast(-1 * temp);
            }
        }
        int[] ans = new int[lefts.size() + rights.size()];
        int l = 0;
        while (!rights.isEmpty()){
            ans[l++] = rights.pollFirst();
        }
        while (!lefts.isEmpty()){
            ans[l++] = lefts.pollLast();
        }
        return ans;
    }
    public static void main(String[] args){
        MasteroidCollision q = new MasteroidCollision();

    }
}
