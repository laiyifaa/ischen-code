package hot_100.array;

public class canPlaceFlowers {
    //605. 种花问题
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(null == flowerbed || 0 == flowerbed.length || n < 0 || n > flowerbed.length)
            return false;
        if(n == 0 )
            return true;
        for(int i = 0;i<flowerbed.length;){
            if(flowerbed[i] == 1 ){
                i+=2;
                continue;
            }else {
                if(i == 0 ){
                    if(i+1 == flowerbed.length || flowerbed[i+1] == 0  ){
                        flowerbed[i] = 1;
                        i+=2;
                        --n;
                        continue;
                    }
                }
                else if(i == flowerbed.length - 1 ){
                    if(flowerbed[i-1] == 0)
                    flowerbed[i] = 1;
                    --n;
                    break;
                }else if(i - 1 >=0 && i+1 < flowerbed.length &&flowerbed[i -1] == 0 && flowerbed[i + 1] == 0){
                    flowerbed[i] = 1;
                    i+=2;
                    --n;
                    continue;
                }
            }
            ++i;
            if(n <= 0)
                break;
        }
        return n <= 0?true:false;
    }
    public static void main(String[] args){  
        canPlaceFlowers q = new canPlaceFlowers();
        System.out.println(q.canPlaceFlowers(new int[]{
               0,0,1,0,0
        },1));

    }
}
