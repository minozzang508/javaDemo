package Algorithm.tp9;

public class alg_ex_findN {
    // 1 <= N <= 9
    // 1 <= number <= 32000
    // 1 <= answer <= 8 || -1

    public static int solution (int N, int number){
        int answer = 0;
        int[][] dp = new int[8][];

        for(int i = 0; i < 8; i++){
            dp[i] = new int[i+1];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5,12)); //return 4
        System.out.println(solution(2,11)); //return 3
    }
}
