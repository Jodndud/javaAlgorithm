package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b17086 {

    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    static boolean[][] visited;

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N][M];
        for(int i=0;i<N;i++){
            String[] num = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(num[j]);
            }
        }

        int max=0;
        max = bfs();
        System.out.println(max);
    }

    private static int bfs() {
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j] == 1){
                    q.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int maxDist = 0;

        while(!q.isEmpty()){
            int[] stack = q.poll();

            for(int i=0;i<8;i++){
                int nx = stack[0] + dx[i];
                int ny = stack[1] + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, stack[2]+1});
                    maxDist = Math.max(maxDist, stack[2] + 1);
                }
            }
        }
        return maxDist;
    }
}
