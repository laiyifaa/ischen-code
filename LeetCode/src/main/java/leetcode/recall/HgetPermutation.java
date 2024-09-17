package leetcode.recall;

import java.util.*;

public class HgetPermutation {

    public int factor(int n){
        int num=1;
        while(n>0){
            num=num*(n--);
        }
        return num;
    }
    public void del(int[] num,int length,int k){
        while (k<length-1){
            num[k]=num[k+1];
            k++;
        }

    }
    public String getPermutation(int n, int k) {
        StringBuffer ans=new StringBuffer();
        int[] temp=new int[n];
        k=k-1;
        int factor=0;
        for(int i=0;i<n;i++){
            temp[i]=i+1;
        }
        for(int i=0;i<n;i++){
            factor=factor(n-i-1);
            ans.append(temp[k/factor]);
            del(temp,n-i,k/factor);
            k=k%factor;
        }
        return ans.toString();
    }
    public static void main(String[] args){  
        HgetPermutation q = new HgetPermutation();
        System.out.println(q.getPermutation(3,5));
    }
}
