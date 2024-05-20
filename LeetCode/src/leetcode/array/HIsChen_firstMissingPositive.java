package leetcode.array;

public class HIsChen_firstMissingPositive {
    //41. 缺失的第一个正数
    //空间 ：原地哈希 O(1) 哈希表O（N） 排序O（LOGN）
    //原地哈希 将数组作为哈希表 ，此题的规则是 f(nums[i]=nums[i] -1) 即数组中的 i-1下标对应的是i，如果是非1-num.length的数不处理
    public int firstMissingPositive(int[] nums) {
        if(null == nums || 0 == nums.length)
            return 0;
        for(int i = 0;i < nums.length;i++){
            while (nums[i]>=1 && nums[i] <=nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums[i]-1,i,nums);
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!= i+1)
                return i+1;
        }
        return nums.length+1;
    }
    private void  swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
