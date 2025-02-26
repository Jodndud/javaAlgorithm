package wooyeong;

import java.io.*;
import java.util.*;

public class dp_example_3_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[M+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = coin[i]; j <= M; j++) {
                 if(dp[j-coin[i]] != 10001){
                     dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
                 }
            }
        }
        if (dp[M] == 10001) System.out.println(-1);
        else System.out.println(dp[M]);

        System.out.println(dp[M]);
    }
}
