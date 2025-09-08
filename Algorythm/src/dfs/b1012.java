package dfs;

import java.io.*;
import java.util.*;

public class b1012 {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void dfs(int i, int j){
        visited[i][j] = true;

        for(int a=0;a<4;a++){
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==1 && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            count=0;
            for(int a=0;a<N;a++){
                for(int b=0;b<M;b++){
                    if(map[a][b] == 1 && !visited[a][b]){
                        dfs(a, b);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
