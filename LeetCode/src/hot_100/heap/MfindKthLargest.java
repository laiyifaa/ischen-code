package hot_100.heap;

public class MfindKthLargest {
    //215. 数组中的第K个最大元素 经典堆排序
    public int findKthLargest(int[] nums, int k) {
        if(null == nums || 0 == nums.length || k<1)
            return 0;
        for(int i = nums.length / 2 - 1;i >= 0; --i){
            adjustHeap(nums,i,nums.length);
        }
        int cnt = 0;
        while (k>0){
            if(cnt == k)
                break;
            swap(nums,0,nums.length - cnt - 1 );
            adjustHeap(nums,0,nums.length - cnt - 1);
            ++cnt;
        }
        return nums[nums.length - cnt ];
    }

    private  void adjustHeap(int[] num, int i, int len) {
       int temp = num[i];
       for(int j = 2 * i + 1; j < len; j = j * 2 +1){
           if(j + 1 < len && num[j] < num[j + 1]){
               ++j;
           }
           if(num[j] > temp){
               num[i] = num[j];
               i = j;
           }else{
               break;
           }
       }
       num[i] = temp;
    }

    private  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args){
        MfindKthLargest q = new MfindKthLargest();
        System.out.println(q.findKthLargest(new int[]{
                3,2,3,1,2,4,5,5,6
        },4));
    }
}
