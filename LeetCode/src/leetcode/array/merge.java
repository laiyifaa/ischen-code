package leetcode.array;

public class merge {
    //面试题 10.01. 合并排序的数组
    public void merge(int[] A, int m, int[] B, int n) {
        int l = 0;
        int r = 0;
        int k = 0;
        int[] C = new int[m + n];
        while (l < m  && r < n){
            if(A[l] < B[r]){
                C[k++] = A[l++];
            }else {
                C[k++] = B[r++];
            }
        }
        while (l < m ){
            C[k++] = A[l++];
        }
        while (r < n){
            C[k++] = B[r++];
        }
        for(int i = 0 ; i < m + n;++i)
            A[i] = C[i];
    }
    public static void main(String[] args){
        merge q = new merge();
        q.merge(new int[]{
                1,2,3,0,0,0
        }, 3,new int[]{
                2,5,6
        },3);
    }
}
