package leetcode.double_pointer;

public class MmaxArea {
    public int maxArea(int[] height) {
        if(null == height || height.length<2)
        return 0;
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while(l<r){
            int c = Math.min(height[l],height[r]);
            int temp = c * (r - l);
            if(temp > ans){
                ans = temp;
            }
            if(height[l] < height[r])
                l++;
            else r--;
        }
        return ans;
    }
    public static void main(String[] args){  
        MmaxArea q = new MmaxArea();
        /*System.out.println(q.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));*/
        System.out.println(q.maxArea(new int[]{1,1}));
    }
}
