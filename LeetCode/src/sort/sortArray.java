package sort;

public class sortArray {
    //912. 排序数组
    //快排模板
    public int[] sortArray(int[] nums) {
        if(null == nums || nums.length <= 1)
            return nums;
        quickSort(nums,0,nums.length - 1);
        return nums;
    }


    private void quickSort(int[] nums, int l, int r) {
        if(l < r){
            int p = partition(nums,l,r);
            quickSort(nums,l,p - 1);
            quickSort(nums,p + 1,r);
        }
    }

    // 5 7 9 8 4 6
     // 4 7 9 8 7 6
     // 4 5 9 8 7 6
    private int partition(int[] nums,int l,int r){
        //可加入随机选取基准
        int temp = nums[l];
        while (l < r){
            while (l < r && temp <= nums[r])
                --r;
            if(l < r)
                nums[l] = nums[r];
            while (l < r && temp >= nums[l])
                ++l;
            if(l < r)
                nums[r] = nums[l];
        }
        nums[l] = temp;
        return l;
    }



    //堆排序模版
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //非叶子先下
        int len = arr.length;
        // 构建大根堆 (即从非叶子开始遍历) ischen 称之位
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
        // 取出堆顶元素，放到已排序的序列中
        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            if (j + 1 < len && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
