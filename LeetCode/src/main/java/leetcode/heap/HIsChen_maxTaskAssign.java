package leetcode.heap;

import java.util.*;

public class HIsChen_maxTaskAssign {
    //2071. 你可以安排的最多任务数目
    //二分答案
    //贪心匹配
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        // 完成任务数量最小值为0，最大值为
        int min = 0;
        int max = Math.min(tasks.length, workers.length);
        // 二分法
        while (min < max) {
            int mid = (min + max + 1) >> 1;
            if(check(mid,tasks,workers,pills,strength)){
                min = mid;
            }else {
                max = mid-1;
            }

        }
        return min;
    }

    private boolean check(int mid, int[] tasks, int[] workers, int pills, int strength) {
        LinkedList<Integer> queue = new LinkedList<>();
        int index = workers.length - 1;
        for(int i = mid - 1;i >= 0;--i){
            int task = tasks[i];
            while (index >= 0 && workers[index] + strength >= task){
                queue.addLast(workers[index]);
                --index;
            }
            if(queue.size() == 0){
                return false;
            }
            if(queue.getFirst() >= task){
                queue.removeFirst();
            }else if(pills-- > 0){
                queue.removeLast();
            }else return false;
        }
        return true;

    }

    public static void main(String[] args){
        HIsChen_maxTaskAssign q = new HIsChen_maxTaskAssign();
        System.out.println(q.maxTaskAssign(new int[]{
                2682,5983,4227,4140,6605,4885,9942,7623,4378,8317,6418,4979,1800,8162,8496,3125,6667,6602,5425,3903,4000,8415,6697,2639,6949,3483,5406,6033,3209,2851,9276,8022,8976,5484,8957,7333,6983,9683,4680,7299,2144,1325,4873,5112,2155,5378,5223,2721,4103,2569,4153,3976,7840,2091,6159,3871,6332,4651,4954,6572,7530,9273,6568,4910,9646,3725,5501,9860,1111,5491,2431,7009,1133,9220,8401,2723,2226,9777,6862,7656,4847,5923,5141,9976,3656,1654,6426,7951,5309,8481,2123,3865,8926,7629,8824,6944,4746,9033,9240,3053,7207,1105,3510,3596,4766,5276,5345,1376,9940,6297,7947,1622,1188,2207,4621,6429,7917,3631,4188,1917,1820,3109,1364,7741,6748,1156,6333,9556,8571,6552,7002,2802,3206,5623,7489,7380,9069,3637,4063,2829,5491,9453,8927,4778,3077,7911,7577,4992,1341,2717,9695,4064,6068,2351,4957,9653,3578,8843,9891,2000,6620,8686,1688,8952,7888,4190,1081,5581,4165,5425,9321,8857,6819,9173,4686,7888,4641,2316,4319,4053,8851,3714,7590,1680,1025,2228,7468,5508,2467,5312,3366,9649,9885,6459,4300,3633,9386,3823,9914
        },new int[]{
                4922,3738,4552,4444,2448,3694,3263,546,1609,2574,2491,3544,2716,1712,1863,1141,4827,1388,3731,3771,3366,697,3870,1014,4332,604,3540,3938,3822,1870,3759,4842,863,3039,2509,839,2380,3834,4660,680,1445,4384,2202,4609,2193,3194,3462,3148,2314,3164,4694,1227,1412,4115,961,2684,2670,3490,4981,2250,4068,3302,996,1148,1725,1713,3548,4912,1953,4603,3389,1697,3860,2171,963,2269,2971,999,1504,4473,1434,4133,813,1190,4341,3906,1905,1648,846,2180,1871,1547,2424,4872,3340,1412,4028,2889,2617,3446,1565,4315,3223,1377,4020,4989,2671,2366,3989,4860,2475,1921,3340,3036,1547,4002,1596,1535,3949,1668,1105,714,831,4295,4444,4564,3472,3476,3149,3072,3291,676,2589,3153,3999,3952,2121,4493,2086,797,2045,2857,2323,4228,1373,1098,3842,3147
        },144,6541));
    }
}