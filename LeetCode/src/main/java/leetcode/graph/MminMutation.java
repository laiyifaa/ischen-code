package leetcode.graph;

import java.util.HashMap;
import java.util.LinkedList;

public class MminMutation {

    class node {
        private String gene;
        private int step;

        public node(String gene, int step) {
            this.gene = gene;
            this.step = step;
        }
    }
    char[] a = new char[]{
            'A','C','G','T'
    };
    //433. 最小基因变化
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene == null || endGene == null || startGene.length() != endGene.length())
            return -1;
        if(startGene.equals(endGene))
            return 0;
        if(bank.length == 0)
            return -1;
        HashMap<String,Integer> geneMap = new HashMap<>(bank.length);
        for(String gene : bank){
            geneMap.put(gene,1);
        }
        if(!geneMap.containsKey(endGene))
            return -1;
        LinkedList<node> queue = new LinkedList<>();
        queue.addLast(new node(startGene,0));
        if(geneMap.containsKey(startGene)){
            geneMap.put(startGene,0);
        }
        char[] temp;
        int ans = -1;
        while (!queue.isEmpty()){
            node curGene = queue.pollFirst();
            if(curGene.gene.equals(endGene)){
                ans = curGene.step;
                break;
            }
            int newStep = curGene.step + 1;
            temp = curGene.gene.toCharArray();
            for(int i = 0;i < temp.length;++i){
                for(int j = 0;j < a.length;++j){
                    char oldChar = temp[i];
                    temp[i] =a[j];
                    String newGene = new String(temp);
                    if(geneMap.getOrDefault(newGene,0) > 0){
                        queue.addLast(new node(newGene,newStep));
                        geneMap.put(newGene,0);
                    }
                    temp[i] = oldChar;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){  
        MminMutation q = new MminMutation();
        String[]bank  = new String[]{
                "AACCGGTA"
        };
        System.out.println(       q.minMutation("AACCGGTT",
                "AACCGGTA",bank
        ));
    }
}
