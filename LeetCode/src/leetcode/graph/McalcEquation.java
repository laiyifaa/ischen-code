package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class McalcEquation {
    //399. 除法求值
    Map<String,Integer> map;
    Map<String,Integer> dict;
    int pointCnt ;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>(equations.size());
        dict = new HashMap<>(equations.size());
        pointCnt = 0;
        double[][] matrix = getMap(equations,values);
        double[] ans = getAns(queries,matrix);
        return ans;
    }

    private double[] getAns(List<List<String>> queries,double[][] matrix) {
        double[] ans = new double[queries.size()];
        int cnt = 0;
        for(List<String> sList : queries){
            String start = sList.get(0);
            String end = sList.get(1);
            Integer[] temp = getXandY(start, end);
            Integer x = temp[0];
            Integer y = temp[1];
            if(x == -1 || y == -1){
                ans[cnt++] = -1;
                continue;
            }
            if(x == y){
                ans[cnt++] = 1;
                continue;
            }
            if(matrix[x][y] == -1){
                ans[cnt++] = -1;
            }else {
                ans[cnt++] = matrix[x][y];
            }

        }
        return ans;
    }

    private double[][] getMap(List<List<String>> equations, double[] values) {
        for(List<String> sList : equations){
            String start = sList.get(0);
            String end = sList.get(1);
            dict.put(start,1);
            dict.put(end,1);
            addMap(start,end);
        }
        int i;
        double[][] matrix = new double[pointCnt][pointCnt];
        for( i = 0;i < pointCnt;++i){
            for(int j = 0;j < pointCnt;++j)
                matrix[i][j] = -1;
            matrix[i][i] = 1.0;
        }
        i = 0;
        for(List<String> sList : equations){
            String start = sList.get(0);
            String end = sList.get(1);
            Integer[] temp = getXandY(start, end);
            matrix[temp[0]][temp[1]] = values[i];
            matrix[temp[1]][temp[0]] = 1/values[i++];
        }
        //floyd
        for(int k = 0 ; k < pointCnt;++k){
            for(i = 0; i < pointCnt;++i){
                for(int j = 0; j < pointCnt;++j){
                    if(i == j)
                        continue;
                    if(matrix[i][k] > 0 && matrix[k][j] > 0){
                       double temp = matrix[i][k] * matrix[k][j];
                       if(matrix[i][j] == -1)
                           matrix[i][j] = temp;
                       else if(matrix[i][j] > temp)
                           matrix[i][j] = temp;
                    }
                }
            }
        }
        return matrix;
    }
    private Integer[] getXandY(String start,String end){
        Integer[] ans = new Integer[]{-1,-1};
        if(!dict.containsKey(start) || !dict.containsKey(end))
            return ans;
        if(start.equals(end))
            return new Integer[]{0,0};
        if(map.containsKey(start) && map.containsKey(end))
            return new Integer[]{map.get(start),map.get(end)};
        if(start.length() == 1 && end.length() == 1){
            ans[0] = map.get(start);
            ans[1] = map.get(end);
        }else{
            StringBuilder[] temps = getStringTemp(start, end);
            String s = temps[0].toString();
            String t = temps[1].toString();
            ans[0] = map.get(s);
            ans[1] = map.get(t);
        }
        return ans;
    }
    private void addMap(String start, String end) {
        if(start.length() == 1 && end.length() == 1){
            if(!map.containsKey(start)){
                map.put(start,pointCnt++);
            }
            if(!map.containsKey(end)){
                map.put(end,pointCnt++);
            }
        }else {
            if(containNumeric(start) || containNumeric(end)){
                map.put(start,pointCnt++);
                map.put(end,pointCnt++);
                return;
            }
            StringBuilder[] temps = getStringTemp(start, end);
            String s = temps[0].toString();
            String e = temps[1].toString();
            if(!map.containsKey(s)){
                map.put(s,pointCnt++);
            }
            if(!map.containsKey(e)){
                map.put(e,pointCnt++);
            }
        }
    }
    StringBuilder[] getStringTemp(String start,String end){
        StringBuilder sTemp = new StringBuilder();
        StringBuilder eTemp = new StringBuilder();
        int[] used = new int[128];
        for(int i = 0;i  < start.length();++i){
            used[start.charAt(i)]++;
        }
        for(int i = 0 ;i < end.length();++i){
            if(used[end.charAt(i)] > 0){
                used[end.charAt(i)]--;
            }else eTemp.append(end.charAt(i));
        }
        for(int i = 0;i < 128;++i){
            if(used[i]>0)
                sTemp.append((char)i);
        }

        return new StringBuilder[]{sTemp,eTemp};
    }
    public static boolean containNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (Character.isDigit(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){  
        McalcEquation q = new McalcEquation();
        List<List<String>> equations = new ArrayList<>();
        List<List<String>> queries  = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        List<String> equation2 = new ArrayList<>();
        List<String> equation3 = new ArrayList<>();
        List<String> equation4 = new ArrayList<>();
        List<String> equation5 = new ArrayList<>();
        List<String> equation6 = new ArrayList<>();
        List<String> equation7 = new ArrayList<>();
        List<String> equation8 = new ArrayList<>();
        List<String> equation9 = new ArrayList<>();
        List<String> equation10 = new ArrayList<>();
        List<String> equation11 = new ArrayList<>();
        List<String> equation12 = new ArrayList<>();
        List<String> equation13 = new ArrayList<>();
        List<String> equation14 = new ArrayList<>();
        List<String> equation15 = new ArrayList<>();
        List<String> equation16 = new ArrayList<>();
        List<String> equation17 = new ArrayList<>();
        List<String> equation18 = new ArrayList<>();
        List<String> equation19 = new ArrayList<>();
        List<String> equation20 = new ArrayList<>();
        List<String> querie1 = new ArrayList<>();

        equation1.add("b");equation1.add("a");
        equation2.add("c");equation2.add("b");
        equation3.add("d");equation3.add("c");
        equation4.add("e");equation4.add("d");
        equation5.add("f");equation5.add("e");
        equation6.add("g");equation6.add("f");
        equation7.add("h");equation7.add("g");
        equation8.add("i");equation8.add("h");
        equation9.add("j");equation9.add("i");
        equation10.add("k");equation10.add("j");
        equation11.add("k");equation11.add("l");
        equation12.add("l");equation12.add("m");
        equation13.add("m");equation13.add("n");
        equation14.add("n");equation14.add("o");
        equation15.add("o");equation15.add("p");
        equation16.add("p");equation16.add("q");
        equation17.add("q");equation17.add("r");
        equation18.add("r");equation18.add("s");
        equation19.add("s");equation19.add("t");
        equation20.add("t");equation20.add("u");
        querie1.add("a");querie1.add("u");
        equations.add(equation1);equations.add(equation2);equations.add(equation3);equations.add(equation4);
        equations.add(equation5);equations.add(equation6);equations.add(equation7);
        equations.add(equation8);equations.add(equation9);equations.add(equation10);
        equations.add(equation11);equations.add(equation12);equations.add(equation13);
        equations.add(equation14);equations.add(equation15);equations.add(equation16);
        equations.add(equation17);equations.add(equation18);equations.add(equation19);
        equations.add(equation20);

        queries.add(querie1);
        double[] doubles = q.calcEquation(equations, new double[]{
                1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05,1e-05
        }, queries);
        for(int i = 0;i < doubles.length;++i){
            System.out.println(doubles[i]);
        }
    }
}
