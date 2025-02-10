package wooyeong.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[12];

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int j = 4; j < N+1; j++) {
                for (int k = 1; k < 4; k++) {
                    dp[j] += dp[j-k];
                }
            }

            System.out.println(dp[N]);
        }

        br.close();
    }

}