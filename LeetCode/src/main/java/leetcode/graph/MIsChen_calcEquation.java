package leetcode.graph;

import java.util.*;

public class MIsChen_calcEquation {
    //399. 除法求值
    private int pointCnt;
    boolean used[];
    boolean flag ;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double ans[] = new double[queries.size()];
        pointCnt = 0;
        Map<String,Integer> map = new HashMap<>(equations.size());
        for (List<String> equation : equations) {
            if (!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), pointCnt++);
            }
            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), pointCnt++);
            }
        }
        double[][] matrix = new double[pointCnt][pointCnt];
        used = new boolean[pointCnt];
        for(int i = 0;i < pointCnt;++i){
            for(int j = 0; j < pointCnt;++j){
                matrix[i][j] = -1;
            }
            matrix[i][i] = 1;
        }
        for(int i = 0;i < values.length;++i){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            matrix[map.get(a)][map.get(b)] = values[i];
            matrix[map.get(b)][map.get(a)] = 1.0/values[i];
        }
        /*folyd
        for(int k = 0; k < pointCnt;++k){
            for(int i = 0;i < pointCnt;++i){
                for (int j = 0; j < pointCnt;++j){
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
        }*/
        for(int i = 0;i < queries.size();++i){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if(!map.containsKey(a) || !map.containsKey(b)){
                ans[i] = -1.0;
                continue;
            }
            Arrays.fill(used,false);
            flag = false;
            used[map.get(a)] = true;
            ans[i]  = dfs(map.get(a),map.get(b),used,matrix,1.0);
            matrix[map.get(a)][map.get(b)] = ans[i];
        }
        return ans;
    }

    private double dfs(Integer a, Integer b, boolean[] used, double[][] matrix,double res) {
        if(matrix[a][b] != -1.0){
            flag = true;
            return  res * matrix[a][b];
        }
        for(int i = 0;i < pointCnt;++i){
            if(!used[i] && matrix[a][i] != -1.0){
                used[i] = true;
                double ans =  dfs(i,b,used,matrix,res * matrix[a][i]);
                if(flag)
                    return ans;
                used[i] = false;
            }
        }
        return -1.0;
    }

    public static void main(String[] args){
        MIsChen_calcEquation q = new MIsChen_calcEquation();
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
