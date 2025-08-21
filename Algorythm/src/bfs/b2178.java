package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class b2178 {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new boolean[N][M];

        map = new int[N][M];
        for(int i=0;i<N;i++){
            String[] line = br.readLine().split("");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(bfs(1) + 1);
    }

    private static int bfs(int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, c});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            for(int a=0;a<4;a++){
                int nx = x + dx[a];
                int ny = y + dy[a];

                if(nx==N-1 && ny==M-1){
                    return count;
                }

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]){
                    if(map[nx][ny]==1){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, count+1});
                    }
                }
            }
        }
        return -1;
    }
}
