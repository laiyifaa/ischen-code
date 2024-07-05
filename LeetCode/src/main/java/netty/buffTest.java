package netty;

import java.nio.IntBuffer;
import java.util.Arrays;

public class buffTest {
    public static void main(String[] args){
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(1);
        buffer.put(22);
        int[] arr = new int[]{3333,444};
        System.out.println(Arrays.toString(buffer.array()));
        buffer.put(arr);
        System.out.println(Arrays.toString(buffer.array()));
        arr = new int[]{6566,777};
        buffer.put(arr,1,1);
        System.out.println(Arrays.toString(buffer.array()));
    }
}
