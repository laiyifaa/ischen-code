package hot_100.heap;

public class heapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
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
    public static void main(String[] args){
        int []a  = new int[]{3,1,5,9,8};
        heapSort(a);
        for(int i = 0;i< a.length;++i){
            System.out.print(a[i]);
        }
    }
}
