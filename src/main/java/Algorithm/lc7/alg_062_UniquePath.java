package Algorithm.lc7;

public class alg_062_UniquePath {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
    //Memory Usage: 31.9 MB, less than 100.00% of Java online submissions for Unique Paths.
    public static int uniquePaths(int m, int n){
        int moveCnt = (m-1) + (n-1);
        long answer = 1;
        //aCn
        int min = Math.min(m-1, n-1);
        for(int i = 0; i < min; i++){
            answer *= (moveCnt - i);
            answer /= (i + 1);
        }

        return (int)answer;
    }

    //dfs 배열로 풀기
    public static int uniquePaths2(int n, int m){
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        //23,12 -> expected : 193536720
        //System.out.println(uniquePaths(23, 12));

        //59,5 -> expected : 557845
        System.out.println(uniquePaths2(59,5));
    }
}
