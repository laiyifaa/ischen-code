package leetcode.array;

import java.util.Arrays;

public class MwiggleSortII {


    //324.摆动排序II
    public void wiggleSort(int[] nums) {

        int len = nums.length;
        int midElement = getMidElement(nums);
/*        for(int i = 0;i < nums.length;++i){
            System.out.print(nums[i] + " ");
        }
        System.out.println();*/
        int i = 0;
        int j = len - 1;
        int index = 0;
        //三趟划分
        while (index < j){
            if(nums[index] == midElement)
                ++index;
            else if(nums[index] > midElement)
                swap(nums,index,j--);
            else
                swap(nums,index++,i++);
        }
        int midIndex = (len + 1)/2;
        int[]firstHalf = Arrays.copyOfRange(nums,0,midIndex);
        int[]secondHalf = Arrays.copyOfRange(nums,midIndex,len);
        int firstIndex = firstHalf.length - 1;
        int secondIndex = secondHalf.length - 1;
        index = 0;
        while (firstIndex >= 0 && secondIndex >= 0){
            nums[index ++ ] = firstHalf[firstIndex -- ];
            nums[index ++ ] = secondHalf[secondIndex -- ];
        }
        if(firstIndex >= 0)
            nums[index] = firstHalf[firstIndex];
/*        for( i = 0;i < nums.length;++i){
            System.out.print(nums[i] + " ");
        }
        System.out.println();*/

    }
    private void swap(int[] nums,int l,int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    private int getMidElement(int[] nums) {
        int len = nums.length;
        int targetIndex = len / 2;
        int l = 0;
        int r = len - 1;
        while (true){
            int p = partition(nums,l,r);
            if(p == targetIndex)
                return nums[targetIndex];
            else if(p > targetIndex){
                r = p - 1;
            }
            else l = p + 1;
        }
    }

    private int partition(int[] nums, int l, int r) {
        if(l == r)
            return l;
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
    public static void main(String[] args){
        MwiggleSortII q = new MwiggleSortII();
        q.wiggleSort(new int[]{
                1
        });
    }
}
