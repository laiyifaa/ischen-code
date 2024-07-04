package leetcode.array;

public class HreversePairs {
    //LCR 170. 交易逆序对的总数
    public int reversePairs(int[] record) {
        int len = record.length;
        this.record = record;
        temp = new int[len];
        if (len < 2) {
            return 0;
        }
        return mergeSort(0,len - 1);
    }

    int [] temp,record ;
    public int mergeSort(int l,int r){
        if(l >= r)
            return 0 ;
        int mid = l + (r - l)/2;
        int res = mergeSort(l,mid) + mergeSort(mid + 1,r);
        int i = l;
        int j = mid + 1;
        for(int k = l;k<=r;++k)
            temp[k] = record[k];
        int cnt = l;
        while (i <= mid && j <= r){
            if(temp[i] <= temp[j])
                record[cnt++] = temp[i++];
            else {
                record[cnt++] = temp[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid)
            record[cnt++] = temp[i++];
        while (j <= r){
            record[cnt++] = temp[j++];
        }
        return res;
    }
    public static void main(String[] args){
        HreversePairs q = new HreversePairs();
        System.out.println(q.reversePairs(new int[]{
            7,3,2,6,0,1,5,4
        }));
    }
}
