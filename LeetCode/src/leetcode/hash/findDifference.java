package leetcode.hash;

import java.util.*;

public class findDifference {
    //2215. 找出两数组的不同
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        if(null == nums1 || nums2 == null)
            return null;
        Set<Integer> setA = new HashSet<>(nums1.length);
        Set<Integer> setB = new HashSet<>(nums2.length);
        List<List<Integer>> ans = new ArrayList<>(2);

        for(int i = 0;i < nums1.length;++i){
            setA.add(nums1[i]);
        }
        List<Integer> bList = new LinkedList<>();
        for(int i = 0;i<nums2.length;++i){
            setB.add(nums2[i]);
            if(!setA.contains(nums2[i])){
                bList.add(nums2[i]);
                setA.add(nums2[i]);
            }
        }
        List<Integer> aList = new LinkedList<>();
        for(int i = 0;i<nums1.length;++i){
            if(!setB.contains(nums1[i])){
                aList.add(nums1[i]);
                setB.add(nums1[i]);
            }
        }
        ans.add(aList);
        ans.add(bList);
        return ans;
    }
    public static void main(String[] args){
        findDifference q = new findDifference();
        q.findDifference(new int[]{
                1,2,3,3
        },
                new int[]{
                        1,1,2,2
                });
    }
}
