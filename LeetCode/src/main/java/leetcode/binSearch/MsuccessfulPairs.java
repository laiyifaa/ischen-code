package leetcode.binSearch;

import java.util.Arrays;

public class MsuccessfulPairs {
    private int getBinSearch(int[] potions,long temp,long success){
        int l = 0;
        int r = potions.length - 1;
        if(potions[r] * temp < success)
            return 0;
        if(potions[l] * temp >= success)
            return potions.length;
        while (l<r){
            int mid = l + (r - l) / 2;
            if(potions[mid] * temp < success){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        while (l < potions.length && potions[l] * temp < success){
            ++l;
        }
        return potions.length - l;
    }
    //2300. 咒语和药水的成功对数
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for(int i = 0;i < spells.length;++i){
            long temp  = spells[i];
            spells[i] = getBinSearch(potions,temp,success);
        }
        return spells;
    }
    public static void main(String[] args){
        MsuccessfulPairs q = new MsuccessfulPairs();
        q.successfulPairs(new int[]{
                5,1,3
        },new int[]{
                1,2,3,4,5
        },7);
    }
}
