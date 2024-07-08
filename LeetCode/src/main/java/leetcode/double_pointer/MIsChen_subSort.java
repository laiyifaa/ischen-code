package leetcode.double_pointer;

public class MIsChen_subSort {
    //面试题 16.16. 部分排序
    public int[] subSort(int[] array) {
        if(null == array || array.length <= 1)
            return new int[]{-1,-1};
        int l = 0;
        int r = array.length - 1;
        while ( l != array.length - 1 && array[l] <= array[l + 1])
            ++l;
        while (r != 0 && array[r] >= array[r - 1])
            --r;
        if(l < r){
            int tempMax = Math.max(array[l],array[r]);
            int tempMin = Math.min(array[l],array[r]);
            for(int i = l + 1 ; i <= r - 1;++i){
                tempMax = Math.max(tempMax,array[i]);
                tempMin = Math.min(tempMin,array[i]);
            }
            while (l > 0 && array[l - 1] > tempMin)
                --l;
            while (r < array.length - 1 && array[r + 1] < tempMax )
                ++r;
            return new int[]{l , r};
        }

        return new int[]{-1, -1};
    }

}
