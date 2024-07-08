package leetcode.double_pointer;

public class MtwoSum {
    //167. 两数之和 II - 输入有序数组
    public int[] twoSum(int[] numbers, int target) {
        if(null == numbers || numbers.length < 2)
            return new int[0];
        int l = 0;
        int r = numbers.length - 1;
        while (l < r){
            int temp = numbers[l] + numbers[r];
            if( temp == target)
                break;
            if(temp < target){
                ++l;
            }else {
                --r;
            }
        }
        return new int[]{l + 1,r + 1};
    }
    public static void main(String[] args){
        MtwoSum q = new MtwoSum();
        int a[] = q.twoSum(new int[]{
                5,25,75
        },100);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
}
