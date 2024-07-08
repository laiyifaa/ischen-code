package leetcode.array;

public class MIsChen_canCompleteCircuit {

    //134. 加油站
    //第一次暴力超时了
    //如果一条环路走不通，那么就得从下一个节点开始走环路 （数学验证）
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(null == gas || null == cost)
            return -1;
        if(gas.length  == 0 || cost.length == 0 || gas.length != cost.length)
            return -1;
        int ans = -1;
        int n = gas.length;
        for(int start = 0;start < n && ans == -1;){
            int _gas = 0;
            int index = start;
            while (_gas >= 0 ){
                _gas += gas[index];
                _gas -= cost[index];
                index = (index + 1) % n;
                if(_gas >= 0  && index == start){
                        return start;
                }
            }
            // 如果 x->y 不能形成环路 那么 x<= z <= y, z->y 也是形不成通路的。
            // 即 下一个枚举点从 y + 1开始
            if(index  <=  start){
                break;
            }else {
                start = index;
            }
        }
        return ans;
    }

}
