package leetcode.stack;
import java.util.*;
public class HmaxNumber {


    List<Integer> ansList;
    List <Integer> tempList;
    //321. 拼接最大数
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(null == nums1 || null == nums2)
            return new int[]{};
        if(nums1.length == 0 || nums2.length == 0)
            return new int[]{};

        if(k > nums1.length + nums2.length)
            return new int[]{};
        for(int l = 0; l <= k && l <= nums1.length; ++l){
            List<Integer> aList = getList(nums1,l);
            int r = k - l;
            if(r > nums2.length)
                continue;
            List<Integer> bList = getList(nums2,r);
            merge(aList,bList);
        }
        int[]ans = new int[ansList.size()];
        for(int i = 0;i < ansList.size();++i){
            ans[i] = ansList.get(i);
        }
        return ans;
    }
    private void merge(List<Integer> aList, List<Integer> bList) {
        tempList = new ArrayList<>(aList.size() + bList.size());
        int l = 0;
        int r = 0;
        while (l < aList.size() && r < bList.size()){
            if(aList.get(l) > bList.get(r))
                tempList.add(aList.get(l++));
            else if(aList.get(l) < bList.get(r))
                tempList.add(bList.get(r++));
            else if (aList.get(l) == bList.get(r)){
                int ll = l;
                int rr = r;
                while (ll < aList.size()  && rr < bList.size() && aList.get(ll) == bList.get(rr)){
                    ++ll;
                    ++rr;
                }
                if(ll == aList.size() && rr == bList.size()){
                    break;
                }
                if(ll == aList.size() ){
                    tempList.add(bList.get(r++));
                    continue;
                }else if(rr == bList.size()){
                    tempList.add(aList.get(l++));
                    continue;
                }

                if(  aList.get(ll) > bList.get(rr))
                    tempList.add(aList.get(l++));
                else tempList.add(bList.get(r++));
            }
        }
        while (l < aList.size())
            tempList.add(aList.get(l++));
        while (r < bList.size())
            tempList.add(bList.get(r++));
        if(ansList == null){
            ansList = tempList;
            return;
        }
        for(int i = 0;i < ansList.size();++i){
            if(ansList.get(i)  > tempList.get(i)){
                return;
            }else if(ansList.get(i) < tempList.get(i)){
                ansList = tempList;
                return;
            }
        }

    }

    private List<Integer> getList(int[] nums, int cnt) {
        if(cnt == 0)
            return new LinkedList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0;i < nums.length ;++i){
            if(stack.size() < cnt){
                if(stack.isEmpty() || nums[i] <= stack.peekLast() || nums.length - i == cnt - stack.size() ){
                    stack.addLast(nums[i]);
                    continue;
                }
            }
            if(stack.peekLast() > nums[i])
                continue;
            while (!stack.isEmpty() && nums[i] > stack.peekLast() && nums.length - i  > cnt - stack.size() ){
                stack.pollLast();
            }
            if(stack.size() == cnt)
                continue;
            stack.addLast(nums[i]);
        }
        List<Integer> ansList = new ArrayList<>(stack);
        return ansList;
    }
    public static void main(String[] args){  
        HmaxNumber  q = new HmaxNumber();
        int[]ans = new int[]{
                2,1,1,1,0,2,1,2,2,2,2,0,1,0,0,2,0,2,0,2,1,0,1,1,0,1,0,1,2,1,1,1,0,1,2,2,1,0,0,1,2,1,2,2,1,1,0,1,2,0,2,0,1,2,0,2,1,1,1,2,0,0,1,1,0,2,1,0,1,2,1,0,2,2,1,0,2,0,1,1,0,0,2,2,0,1,0,2,0,2,2,2,2,1,1,1,1,0,0,1,0,2,1,2,0,1,0,0,0,1,2,1,0,1,1,2,0,2,2,0,0,1,1,2,2,1,1,2,2,1,0,1,2,0,1,2,2,0,0,0,2,0,2,0,2,2,0,1,1,1,1,2,2,2,2,0,0,2,2,2,2,0,2,0,1,0,0,2,1,0,0,2,0,2,1,1,1,1,0,1,2,0,2,1,0,1,1,1,0,0,2,2,2,0,2,1,1,1,2,2,0,0,2,2,2,2,2,0,2,0,2,0,2,0,0,1,0,1,1,0,0,2,1,1,2,2,2,1,2,2,0,0,2,1,0,2,1,2,1,1,1,0,2,0,1,1,2,1,1,0,0,1,0,1,2,2,2,0,2,2,1,0,1,2,1,2,0,2,2,0,1,2,2,1,2,2,1,1,2,2,2,2,2,1,2,0,1,1,1,2,2,2,0,2,0,2,0,2,1,1,0,2,2,2,1,0,2,1,2,2,2,0,1,1,1,1,1,1,0,0,0,2,2,0,1,2,1,0,0,2,2,2,2,1,0,2,0,1,2,0,0,0,0,2,1,0,2,1,1,2,1,2,2,0,2,1,0,2,0,0,2,0,2,2,1,0,1,0,0,2,1,1,1,2,2,0,0,0,1,1,2,0,2,2,0,1,0,2,1,0,2,1,1,1,0,1,1,2,0,2,0,1,1,2,0,2,0,1,2,1,0,2,0,1,0,0,0,1,2,1,2,0,1,2,2,1,1,0,1,2,1,0,0,1,0,2,2,1,2,2,0,0,0,2,0,0,0,1,0,2,0,2,1,0,0,1,2,0,1,1,0,1,0,2,2,2,1,1,0,1,1,2,1,0,2,2,2,1,2,2,2,2,0,1,1,0,1,2,1,2,2,0,0,0,0,0,1,1,1,2,1,2,1,1,0,1,2,0,1,2,1,2,2,2,2,0,0,0,0,2,0,1,2,0,1,1,1,1,0,1,2,2,1,0,1,2,2,1,2,2,2,0,2,0,1,1,2,0,0,2,2,0,1,0,2,1,0,0,1,1,1,1,0,0,2,2,2,2,0,0,1,2,1,1,2,0,1,2,1,0,2,0,0,2,1,1,0,2,1,1,2,2,0,1,0,2,0,1,0,0
        };

        int[] ints = q.maxNumber(new int[]{
                2,0,2,1,2,2,2,2,0,1,0,0,2,0,2,0,2,1,0,1,1,0,1,0,1,2,1,1,1,0,1,2,2,1,0,0,1,2,1,2,2,1,1,0,1,2,0,2,0,1,2,0,2,1,1,1,2,0,0,1,0,2,1,2,0,1,0,0,0,1,2,1,0,1,1,2,0,2,2,0,0,1,1,2,2,1,1,2,2,1,0,1,2,0,1,2,2,0,0,0,2,0,2,0,2,2,0,1,1,1,1,2,2,2,2,0,0,2,2,2,2,0,2,0,1,0,0,2,1,0,0,2,0,2,1,1,1,1,0,1,2,0,2,1,0,1,1,1,0,0,2,2,2,0,2,1,1,1,2,2,0,0,2,2,2,2,2,0,2,0,2,0,2,0,0,1,0,1,1,0,0,2,1,1,2,2,2,1,2,2,0,0,2,1,0,2,1,2,1,1,1,0,2,0,1,1,2,1,1,0,0,1,0,1,2,2,2,0,2,2,1,0,1,2,1,2,0,2,2,0,1,2,2,1,2,2,1,1,2,2,2,2,2,1,2,0,1,1,1,2,2,2,0,2,0,2,0,2,1,1,0,2,2,2,1,0,2,1,2,2,2,0,1,1,1,1,1,1,0,0,0,2,2,0,1,2,1,0,0,2,2,2,2,1,0,2,0,1,2,0
        }, new int[]{
                1,1,1,0,0,1,1,0,2,1,0,1,2,1,0,2,2,1,0,2,0,1,1,0,0,2,2,0,1,0,2,0,2,2,2,2,1,1,1,1,0,0,0,0,2,1,0,2,1,1,2,1,2,2,0,2,1,0,2,0,0,2,0,2,2,1,0,1,0,0,2,1,1,1,2,2,0,0,0,1,1,2,0,2,2,0,1,0,2,1,0,2,1,1,1,0,1,1,2,0,2,0,1,1,2,0,2,0,1,2,1,0,2,0,1,0,0,0,1,2,1,2,0,1,2,2,1,1,0,1,2,1,0,0,1,0,2,2,1,2,2,0,0,0,2,0,0,0,1,0,2,0,2,1,0,0,1,2,0,1,1,0,1,0,2,2,2,1,1,0,1,1,2,1,0,2,2,2,1,2,2,2,2,0,1,1,0,1,2,1,2,2,0,0,0,0,0,1,1,1,2,1,2,1,1,0,1,2,0,1,2,1,2,2,2,2,0,0,0,0,2,0,1,2,0,1,1,1,1,0,1,2,2,1,0,1,2,2,1,2,2,2,0,2,0,1,1,2,0,0,2,2,0,1,0,2,1,0,0,1,1,1,1,0,0,2,2,2,2,0,0,1,2,1,1,2,0,1,2,1,0,2,0,0,2,1,1,0,2,1,1,2,2,0,1,0,2,0,1,0
        }, 600);
        System.out.println(ints.length);
        System.out.println(ans.length);
        for(int i = 0;i < ints.length;++i){
            if(ans[i] != ints[i])
                System.out.println(ints[i]);
        }
    }
}
