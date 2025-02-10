package wooyeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[][] arr = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[i][0] = t;
            arr[i][1] = p;
        }

        int max = -1;
        for (int i = 1; i <= N+1; i++) {
            if(max<dp[i]){
                max = dp[i];
            }

            int ntd = i + arr[i][0];
            if(ntd < N+2){
                dp[ntd] = Math.max(dp[ntd], max+arr[i][1]);
            }
        }
        System.out.println(dp[N+1]);
    }
}
