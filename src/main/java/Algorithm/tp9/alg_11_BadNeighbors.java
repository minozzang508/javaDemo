package Algorithm.tp9;

public class alg_11_BadNeighbors {
    public int maxDonations(int[] donations){
        int i;
        int ans = 0;

        int N = donations.length;
        int [] dp = new int[N];

        for(i = 0; i < N - 1; i++){
            dp[i] = donations[i];
            if(i > 0) dp[i] = Math.max(dp[i], dp[i-1]);
            if(i > 1) dp[i] = Math.max(dp[i], dp[i - 2] + donations[i]);

            ans = Math.max(ans,dp[i]);
        }

        for(i = 0; i < N - 1; i++){
            dp[i] = donations[i + 1];
            if(i > 0) dp[i] = Math.max(dp[i], dp[i-1]);
            if(i > 1) dp[i] = Math.max(dp[i], dp[i - 2] + donations[i + 1]);

            ans = Math.max(ans,dp[i]);
        }

        return ans;
    }
}
