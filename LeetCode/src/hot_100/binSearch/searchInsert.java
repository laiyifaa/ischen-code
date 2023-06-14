package hot_100.binSearch;

public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target )
                r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
    public static void main(String[] args){
        searchInsert q = new searchInsert();
        System.out.println(q.searchInsert(new int[]{1,3,5,6},7));
    }
}
