package Algorithm.tp9;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//야호 247
public class alg_02_interestingParty {
    public static int bestInvitation(String[] first, String[] second){
        int answer = 0;

        Map<String, Integer> numOfInterest = new HashMap<>();

        for(int i = 0; i < first.length; i++){
            if(numOfInterest.containsKey(first[i])){
                numOfInterest.replace(first[i], numOfInterest.get(first[i]) + 1);
            }else {
                numOfInterest.put(first[i], 1);
            }

            if(numOfInterest.containsKey(second[i])){
                numOfInterest.replace(second[i], numOfInterest.get(second[i]) + 1);
            }else {
                numOfInterest.put(second[i], 1);
            }
        }

        //Keyset advanced for - loop
        Iterator it = numOfInterest.keySet().iterator();

        while(it.hasNext()){
            int tmp = numOfInterest.get(it.next());
            answer = answer > tmp ? answer : tmp;
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] first = {"test","test","test","fish"};
        String[] second = {"fish","fish","code","test"};

        System.out.println(bestInvitation(first, second));
    }
}
