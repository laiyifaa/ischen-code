package hot_100.binSearch;

public class HfindMedianSortedArrays {
    //4. 寻找两个正序数组的中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(null == nums1 || null == nums2)
            return 0.0;
        if(nums1.length == 0)
            return getMedianValue(nums2);
        if(nums2.length == 0)
            return getMedianValue(nums1);
        int m = nums1.length;
        int n = nums2.length;
        int nums3[] = new int[m + n];
        int a = 0;
        int b = 0;
        int l = 0;
        while (a<m && b <n){
            if(nums1[a]<nums2[b]){
                nums3[l++] = nums1[a++];
            }
            else {
                nums3[l++] = nums2[b++];
            }
        }
        while (a<m){
            nums3[l++] = nums1[a++];
        }
        while (b<n){
            nums3[l++] = nums2[b++];
        }
        return getMedianValue(nums3);
    }
    private double getMedianValue(int[] nums){
        int len = nums.length;
        if((len & 1) == 1)
            return nums[len>>1];
        else
            return (1.0*nums[len>>1] + nums[(len>>1) -1])/2;
    }
    public static void main(String[] args){
        HfindMedianSortedArrays q = new HfindMedianSortedArrays();
        System.out.println( q.findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(q.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
}
