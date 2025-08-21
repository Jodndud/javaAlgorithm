package bfs;

import java.io.*;
import java.util.*;

public class b7576 {
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int startX = 0;
        int startY = 0;

        visited = new int[M][N];

        // 시작점 보관 큐
        q = new ArrayDeque<>();

        // 인접 행렬 생성
        map = new int[M][N];
        for(int i=0;i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
                // 시작점 찾기
                if(map[i][j] == 1){
                    q.add(new int[]{i, j});
                    visited[i][j] = 1;
                }

                // -1은 못가니까 1로 지정해두기
                if(map[i][j] == -1){
                    visited[i][j] = 1;
                }
            }
        }

        bfs(startX, startY);

        // System.out.println(Arrays.deepToString(visited));
        System.out.println(result());
    }

    public static void bfs(int i, int j){
        while(!q.isEmpty()){
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];

            for(int a=0;a<4;a++){
                int nx = x + dx[a];
                int ny = y + dy[a];

                if(nx>=0 && nx<M && ny>=0 && ny<N && visited[nx][ny]==0 && map[nx][ny]==0){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }
    }

    public static int result(){
        int max = 0;
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] == 0){
                    return -1;
                }

                if(visited[i][j] > max){
                    max = visited[i][j];
                }
            }
        }
        return max-1;
    }
}
