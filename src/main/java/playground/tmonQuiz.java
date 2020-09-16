package playground;

/**
 * Created by minho on 2017-05-30.
 */
import java.util.*;
public class tmonQuiz {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[n+1];
        int[] dp = new int[k+1];

        for(int i=1;i<=n;i++){
            A[i]=sc.nextInt();
        }

        dp[0]=1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(A[i]<=j){
                    dp[j]+= dp[j-A[i]];
                }
            }
        }

        System.out.println(dp[k]);
    }
}
