package bfs_dfs;

import java.io.*;
import java.util.*;

public class b16173_1 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        // 인접행렬 채우기
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(bfs(0,0));
    }

    private static String bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];
            int k = map[x][y];

            if(map[x][y] == -1){
                return "HaruHaru";
            }

            for(int a=0;a<4;a++){
                int nx = x + dx[a]*k;
                int ny = y + dy[a]*k;

                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return "Hing";
    }
}