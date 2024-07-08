package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class McompareVersion {

    //165. 比较版本号
    public int compareVersion(String version1, String version2) {
        List<Integer> aList = new ArrayList<>(version1.length() / 2);
        List<Integer> bList = new ArrayList<>(version2.length() / 2);
        initList(aList,version1);
        initList(bList,version2);
        int indexA = 0;
        int indexB = 0;
        while (indexA < aList.size() && indexB < bList.size()){
            int valueA = aList.get(indexA);
            int valueB = bList.get(indexB);
            if(valueA == valueB){
                ++indexA;
                ++indexB;
                continue;
            }
            return compare(valueA,valueB);
        }
        while (indexA < aList.size()){
            int valueA = aList.get(indexA);
            int valueB = 0;
            if(valueA == valueB){
                ++indexA;
                continue;
            }
            return compare(valueA,valueB);
        }
        while (indexB < bList.size()){
            int valueA = 0;
            int valueB = bList.get(indexB);
            if(valueA == valueB){
                ++indexB;
                continue;
            }
            return compare(valueA,valueB);
        }
        return 0;
    }
    private int compare(int valueA,int valueB){
        if(valueA < valueB)
            return -1;
        return 1;
    }
    private void initList(List<Integer> list, String version) {
        String[] nums = version.split("\\.");
        for(String num : nums){
            Integer value = Integer.valueOf(num);
            list.add(value);
        }
    }
    public static void main(String[] args){
        McompareVersion q = new McompareVersion();
        String version1 = "1.001";
        List<Integer> aList = new ArrayList<>(version1.length() / 2);
        System.out.println(aList.size());
        q.initList(aList,version1);
        System.out.println(aList);
        System.out.println(aList.size());
    }
}
