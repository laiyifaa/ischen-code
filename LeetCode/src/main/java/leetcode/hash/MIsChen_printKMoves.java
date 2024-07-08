package leetcode.hash;

import java.util.*;

public class MIsChen_printKMoves {
    //面试题 16.22. 兰顿蚂蚁
    //重写 hashcode equals
    int[][] dir = new int[][]{
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}

    };
    Character[] foward = new Character[]{
            'L',
            'U',
            'R',
            'D',

    };
    class  node {
        int x;
        int y;
        node(int _x,int _y){
            x = _x;
            y = _y;
        }

        // 改写哈希算法，使两个 Position 对象可以比较坐标而不是内存地址
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof node)) return false;
            node o = (node) obj;
            return x == o.x && y == o.y;

        }
    }
    public List<String> printKMoves(int K) {
        node cur  = new node(0,0);
        Map<node,Character> map = new HashMap<>();
        map.put(cur,'_');
        int curForward = 2;
        int minx = 0;
        int maxx = 0;
        int maxy = 0;
        int miny = 0;
        while (K > 0){
            --K;
            if(map.get(cur) == '_'){
                curForward = (curForward + 1) % 4;
                map.put(cur,'X');
            }else {
                curForward = (curForward  + 3)% 4;
                map.put(cur,'_');
            }
            int tempx = cur.x + dir[curForward][0];
            int tempy = cur.y  + dir[curForward][1];
            node temp = new node(tempx,tempy);
            if(!map.containsKey(temp)){
                map.put(temp,'_');
            }
            cur = temp;
            maxx = Math.max(maxx,tempx);
            minx = Math.min(minx,tempx);
            maxy = Math.max(maxy,tempy);
            miny = Math.min(miny,tempy);
        }
        char[][] grid = new char[maxy - miny + 1 ][maxx - minx  + 1 ];
        for(char[] row : grid){
            Arrays.fill(row,'_');
        }
        //偏移
        for(node n : map.keySet()){
            grid[ maxy - n.y][n.x - minx] = map.get(n);
        }
        grid[maxy - cur.y][cur.x - minx] = foward[curForward];
        List<String> result = new ArrayList<>();
        for (char[] row : grid)
            result.add(String.valueOf(row));
        return result;
    }
    public static void main(String[] args){
        MIsChen_printKMoves q = new MIsChen_printKMoves();
        List<String> list = q.printKMoves(2);
        for (String s : list){
            System.out.println(s);
        }
    }
}
