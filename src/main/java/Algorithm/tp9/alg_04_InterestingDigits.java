package Algorithm.tp9;

import java.util.ArrayList;

public class alg_04_InterestingDigits {
    public static int[] digits(int base){
        ArrayList list = new ArrayList();
        int num = 0;
        for(int i = 2; i < base; i++){
            if ( (base - 1) % i == 0){
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = (int) list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
