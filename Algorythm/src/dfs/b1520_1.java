package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1520_1 {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        // dfs
        // 0,0에서 도착지에 도달한 갯수
        System.out.println(dfs(0, 0));
    }

    private static int dfs(int i, int j){
        // 도착지 도달할때마다 왓던곳에 +1
        // 시작점에 1개씩 추가된다.
        if(i==N-1 && j==M-1){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        dp[i][j] = 0; // 시작할때 0하고 시작 (갔던길 표시)
        for(int a=0;a<4;a++){
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx>=0 && nx<N && ny>=0 && ny<M && map[i][j]>map[nx][ny]){
                dp[i][j] += dfs(nx, ny);
            }
        }

        return dp[i][j];
    }
}