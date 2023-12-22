package leetcode.array;


import java.util.TreeSet;

public class IsChen_divingBoard {
    //面试题 16.11. 跳水板
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{shorter * k};
        int[] result = new int[k + 1];
        int start = shorter * k;//这是最短
        //那么第二短应该是 start + (longer - shorter) * 1
        //那么第三短应该是 start + (longer - shorter) * 2
        //以此类推，不是算法题是思路题
        for (int i = 0; i <= k; i++) {
            result[i] = start + (longer - shorter) * i;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
