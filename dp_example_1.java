package wooyeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dp_example_1 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // dp배열 생성
        dp = new int[N];

        int[] wh = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            wh[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = wh[0];
        dp[1] = Math.max(dp[0], wh[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i-2]+wh[i], dp[i-1]);
        }

        System.out.println(dp[N-1]);
    }
}
