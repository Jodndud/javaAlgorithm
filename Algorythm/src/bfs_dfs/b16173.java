package bfs_dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class b16173 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited = new boolean[n][n];
        System.out.println(bfs(0, 0));
    }

    private static String bfs(int x, int y) {
        Queue<int []> q = new LinkedList<>();

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] next = q.poll();
            int a = next[0];
            int b = next[1];

            // 성공 조건
            if(map[a][b] == -1) return "HaruHaru";


            for(int h=0;h<4;h++){
                int nx = a + map[a][b]*(dx[h]);
                int ny = b + map[a][b]*(dy[h]);

                if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]){
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return "Hing";
    }
}
