package Algorithm.tp9;

//야호 246점
public class alg_03_Cryptography {
    public static long encrypt(int[] numbers){
        long answer = 1;
        int lowest = Integer.MAX_VALUE;
        for(int i : numbers){
            lowest = lowest < i ? lowest : i;
            answer *= i;
        }

        answer = answer / lowest * (lowest + 1);

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,2};

        System.out.println(encrypt(numbers));

    }
}
