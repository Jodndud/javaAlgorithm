package dfs;

import java.io.*;
import java.util.*;

public class b1520 {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count=0;

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
                dp[i][j] = -1; // -1로 초기화
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int i, int j){
        if(i==N-1 && j==M-1){ // 끝 점 도달하면 백트래킹하며 1을 계속 추가
            return 1;
        }

        if(dp[i][j] != -1){ // 갔던 경로는 안봐도 됨
            return dp[i][j];
        }

        dp[i][j] = 0; // 갈수있는 길은 0입력 후 시작
        for(int a=0;a<4;a++){
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx>=0 && nx<N && ny>=0 && ny<M && map[i][j] > map[nx][ny]){
                dp[i][j] += dfs(nx, ny);
            }
        }
        return dp[i][j]; // dfs탐색이 끝나면 시작점 누적 횟수 출력
    }
}