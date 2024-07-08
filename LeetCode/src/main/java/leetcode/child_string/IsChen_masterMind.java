package leetcode.child_string;

public class IsChen_masterMind {
    //面试题 16.15. 珠玑妙算
    public int[] masterMind(String solution, String guess) {
        if(null == solution || guess == null)
            return new int[]{};
        if(solution.length() != 4 || guess.length() != 4)
            return new int[]{};
        int ans1 = 0;
        int[][] color = new int[4][2];
        for(int i = 0; i < 4;++i){
            char c1 = solution.charAt(i);
            char c2 = guess.charAt(i);
            ++color[getColor(c1)][0];
            ++color[getColor(c2)][1];
            if(c1 == c2){
                ++ans1;
                --color[getColor(c1)][0];
                --color[getColor(c2)][1];
            }
        }
        int ans2 = 0;
        for(int i = 0 ;i < 4 ;++i){
            if(color[i][0] == 0)
                continue;
                ans2+= Math.min(color[i][0],color[i][1]);
        }
        return new int[]{ans1,ans2};
    }
    private int getColor(char c){
        if(c == 'R')
            return 0;
        if(c == 'G')
            return 1;
        if(c == 'B')
            return 2;
        if(c == 'Y')
            return 3;
        return -1;
    }
}
