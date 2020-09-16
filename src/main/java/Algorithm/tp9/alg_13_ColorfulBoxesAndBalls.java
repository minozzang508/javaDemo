package Algorithm.tp9;

public class alg_13_ColorfulBoxesAndBalls {
    public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors){
        int ans = Integer.MIN_VALUE;

        int change = Math.min(numRed, numBlue);

        for(int i =0 ; i <= change; i++){
            int myScore = (numRed - i) * onlyRed
                    + (numBlue - i) * onlyBlue
                    + 2 * i * bothColors;

            ans = Math.max(ans, myScore);
        }

        return ans;
    }
}
