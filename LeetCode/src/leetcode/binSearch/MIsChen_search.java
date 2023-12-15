package leetcode.binSearch;

public class MIsChen_search {
    //33. 搜索旋转排序数组
/*    public int search(int[] nums, int target) {
        return divide(0,nums.length -1,nums,target);
    }*/
    //面试题 10.03. 搜索旋转数组

    public int search(int[] nums, int target) {
        return divide(0,nums.length -1,nums,target);
    }
    private int divide(int l,int r,int[] nums,int target){
        if(l>r)
            return -1;
        if(nums[l] < nums[r])
            return binSearch(l,r,nums,target);

        int mid = getMid(l,r,nums,target);
        if(nums[mid] == target){
            int lres = divide(l, mid - 1, nums, target);
            if(lres == -1)
                return mid;
            else return lres;
        }
        int lres = divide(l, mid - 1, nums, target);
        int rres = divide(mid + 1,r,nums,target);
        if(lres == -1 && rres == -1)
            return -1;
        if(lres == -1 || rres == -1)
            return Math.max(lres,rres);
        return lres;

    }

    private int getMid(int l, int r, int[] nums, int target) {
        int mid = l + ( r - l) / 2;
        if(nums[mid] == target){
            int temp = mid;
            while (mid >= 0 && nums[mid] == target){
                mid--;
            }
            if(nums[mid + 1] == target)
                return mid + 1;
            else return temp;
        }else return mid;
    }
    private int binSearch(int l,int r,int[] nums,int target){
        if(l>r)
            return -1;
        while (l<=r){
            int mid = getMid(l,r,nums,target);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        MIsChen_search q = new MIsChen_search();
        System.out.println(
                q.search(new int[]{
                        2, 1, 2, 2, 2
                },2)
        );
    }
}
