package Algorithm.lc7;

import java.util.*;

public class alg_684_RedundantConnection {
    public int[] findRedundantConnection(int[][] eddges){
        int[] answer = new int[2];

        Set<List<Integer>> dp = new HashSet<>();

        for(int[] i : eddges){
            int isRedundant = 0;
            for(int j : i){
                Iterator<List<Integer>> it = dp.iterator();
                while (it.hasNext()){
                    List<Integer> graph = it.next();
                    if(graph.contains(j)){
                        isRedundant++;
                        continue;
                    }
                    if(isRedundant == 2){
                        return i;
                    }
                }
            }
        }

        return answer;
    }
}
