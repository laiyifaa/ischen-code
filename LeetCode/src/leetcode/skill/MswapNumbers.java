package leetcode.skill;

public class MswapNumbers {
    //面试题 16.01. 交换数字
    public int[] swapNumbers(int[] numbers) {
        if (null == numbers || numbers.length < 2)
            return numbers;
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }
    public static void main(String[] args){
        int a = 3;
        int b = 4;
        a  = a + b;
        b = a - b;
        a = a - b;
    }
}
