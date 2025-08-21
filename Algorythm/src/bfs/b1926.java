package bfs;

import java.util.*;
import java.io.*;

public class b1926 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            StringTokenizer fields = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(fields.nextToken());
            }
        }

        visited = new boolean[N][M];

        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && map[i][j] == 1){
                    visited[i][j] = true;
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(int i, int j){
        int count = 1;
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{i, j});
        while(!q.isEmpty()){
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];

            for(int a=0;a<4;a++){
                int nx = x + dx[a];
                int ny = y + dy[a];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && map[nx][ny]==1){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }
}
