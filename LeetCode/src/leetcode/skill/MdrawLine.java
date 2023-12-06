package leetcode.skill;

public class MdrawLine {
    //面试题 05.08. 绘制直线
    int cnt ;
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ans = new int[length];
        //一行w个，每32个存一个数
        int x = w / 32;//一行存x个数
        int rows = length / x;
        cnt = 0;
        for(int i = 0; i < rows;++i){
            if(i == y){
                int[] temp = new int[w];
                for(int j = x1;j <= x2;++j){
                    temp[j] = 1;
                }
                for(int j = 0 ;j < x;++j){
                    int z = 0;
                    for(int k = (j) * 32   ;k <=  j * 32 + 31;++k){
                        z<<=1;
                        if(temp[k] == 1){
                            ++z;
                        }

                    }
                    ans[cnt++] = z;
                }
            }else {
                for(int j = 0 ; j < x;++j){
                    ans[cnt++] = 0;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        MdrawLine q = new MdrawLine();
        int[] ints = q.drawLine(3, 96, 0, 95, 0);
        for(int i = 0 ;i < ints.length;++i){
            System.out.println(ints[i]);
        }
    }

}
