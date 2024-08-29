package leetcode.slide_window;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MfindClosestElements {

    //658. 找到 K 个最接近的元素
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(null == arr || arr.length == 0 || k == 0)
            return new LinkedList<>();
        List<Integer> ansList = new ArrayList<>(k);
        if(x < arr[0]){
            for(int i = 0;i < k;++i){
                ansList.add(arr[i]);
            }
        }else if(x > arr[arr.length - 1]){
            for(int i = arr.length - k;i < arr.length;++i){
                ansList.add(arr[i]);
            }
        }else{
            int index = binSearch(arr,x);
              int r = index ;
              int l = r - k ;
              while (l < 0){
                  l++;
                  r++;
              }
              if(r >= arr.length){
                  return findClosestElements(arr,k,arr[0] - 1);
              }
              int ans = 0;
              int ansL = l;
              int ansR = r - 1;
              for(int i = l;i < r;++i){
                  ans += Math.abs(arr[i] - x);
              }
              while (l <= index && r  < arr.length){
                 int temp = ans;
                 temp -= Math.abs(arr[l] - x);
                 temp += Math.abs(arr[r ] - x);
                  if(temp < ans){
                      ans = temp;
                      ansL = l + 1;
                      ansR = r ;
                  }
                 ++l;
                 ++r;
              }
                for(int i = ansL;i <= ansR;++i){
                    ansList.add(arr[i]);
                }
        }
        return ansList;
    }

    private int binSearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == x)
                return mid;
            else if ( arr[mid] < x){
                l = mid  + 1;
            }else r = mid - 1;
        }
        return l;
    }
    public static void main(String[] args){  
        MfindClosestElements q = new MfindClosestElements();
        List<Integer> closestElements = q.findClosestElements(new int[]{
                1,2,3,4,5
        }, 4, 3);
        System.out.println(closestElements);
    }
}
