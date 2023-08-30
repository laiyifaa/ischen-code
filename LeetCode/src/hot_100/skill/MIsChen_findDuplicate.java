package hot_100.skill;

public class MIsChen_findDuplicate {
    //287. 寻找重复数
    public int findDuplicate(int[] nums) {
        if(null == nums || nums.length == 0 || nums.length == 1)
            return 0;
        int slow = 0;
        int quick = 0;
        while (true){
            slow = nums[slow];
            quick = nums[quick];
            quick = nums[quick];
            if(slow == quick)
                break;
        }
        slow = 0;
        while (slow != quick){
            slow = nums[slow];
            quick = nums[quick];
        }
        return slow;
    }
    public static void main(String[] args){
        MIsChen_findDuplicate q = new MIsChen_findDuplicate();
        System.out.println(q.findDuplicate(new int[] {2,5,9,6,9,3,8,9,7,1}));
    }
}
