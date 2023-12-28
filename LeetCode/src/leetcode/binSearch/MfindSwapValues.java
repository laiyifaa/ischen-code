package leetcode.binSearch;

import java.util.Arrays;

public class MfindSwapValues {

    //面试题 16.21. 交换和
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < array1.length;++i)
            sum1 += array1[i];
        for(int i = 0; i < array2.length;++i)
            sum2 += array2[i];
        if(sum1 == sum2)
            return new int[]{array1[0],array2[0]};
        Arrays.sort(array1);
        Arrays.sort(array2);
        if(sum1 > sum2 && sum1 - array1[array1.length - 1] + array2[0] > sum2 + array1[array1.length - 1] - array2[0])
            return new int[]{};
        if(sum2 > sum1 && sum2 - array2[array2.length - 1] + array1[0] > sum1 + array2[array2.length - 1] - array1[0])
            return new int[]{};
        if(sum1 < sum2){
           return solve(array1,array2,sum1,sum2,true);
        }else {
            return solve(array2, array1, sum2, sum1,false);
        }
    }
    private int[] solve(int[] a,int[] b,int sum1,int sum2,boolean flag){
        for(int i = 0; i < a.length;++i){
            int temp = ( sum2 - sum1 +  a[i] * 2 )  ;
            if(binSearch(temp,b)){
                return flag ? new int[]{
                        a[i],temp/2
                }:new int[]{
                        temp/2,a[i]
                };
            }
        }
        return new int[]{};
    }

    private boolean binSearch(int temp, int[] a) {
        if(temp > a[a.length - 1] * 2 || temp < a[0] * 2)
            return false;
        int l = 0;
        int r = a.length - 1;
        while (l <= r){
            int mid = l + ( r - l) / 2 ;
            if(a[mid] * 2  == temp)
                return true;
            if(a[mid] * 2 > temp)
                r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
    public static void main(String[] args) {
        MfindSwapValues q = new MfindSwapValues();
        q.findSwapValues(new int[]{
                4, 1, 2, 1, 1, 2
        },new int[]{
                3, 6, 3, 3
        });
    }
}
