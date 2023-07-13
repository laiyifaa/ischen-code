package hot_100.skill;

public class majorityElement {
    //169. 多数元素
    public int majorityElement(int[] nums) {
        int cnt = 1;
        int num = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(num==nums[i]){
                cnt++;
            }
            else {
                cnt--;
            }
            if(cnt<0){
                num = nums[i];
                cnt = 1;
            }
        }
        return num;
    }
    public static void main(String[] args){
        majorityElement q = new majorityElement();
        System.out.println(q.majorityElement(new int[]{1,2,3,4,4,5,6,7}));
    }
}
