package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1520_2 {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static int dfs(int i, int j){
        // 끝 도달 시 이전 발판에 1추가
        if(i==M-1 && j==N-1){
            return 1;
        }

        // 갔던 길이면 그거 반환
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        dp[i][j] = 0;
        for(int a=0;a<4;a++){
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx>=0 && nx<N && ny>=0 && ny<M && map[i][j]>map[nx][ny]){
                dp[i][j] += dfs(nx, ny);
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }
}
