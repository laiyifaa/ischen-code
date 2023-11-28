package leetcode.stack;

import java.util.LinkedList;

public class AnimalShelf {
    //面试题 03.06. 动物收容所
    LinkedList<Integer[]> dogStack ;
    LinkedList<Integer[]> catStack ;
    int cnt ;
    public AnimalShelf() {
        dogStack = new LinkedList<>();
        catStack = new LinkedList<>();
        cnt = 0;
    }

    public void enqueue(int[] animal) {
        if(animal[1] == 0){
            catStack.addLast(new Integer[]{animal[0],cnt++});
        }else if(animal[1] == 1){
            dogStack.addLast(new Integer[]{animal[0],cnt++});
        }
    }

    public int[] dequeueAny() {
        if(dogStack.isEmpty() && catStack.isEmpty())
            return new int[]{-1,-1};
        if(catStack.isEmpty())
            return dequeueDog();
        if(dogStack.isEmpty())
            return dequeueCat();
        if(catStack.peekFirst()[1] > dogStack.peekFirst()[1]){
            return dequeueDog();
        }else return dequeueCat();
    }

    public int[] dequeueDog() {
        if(!dogStack.isEmpty()){
            return new int[]{dogStack.pollFirst()[0],1};
        }
        return new int[]{-1,-1};
    }

    public int[] dequeueCat() {
        if(!catStack.isEmpty()){
            return new int[]{catStack.pollFirst()[0],0};
        }
        return new int[]{-1,-1};
    }
}
