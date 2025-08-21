package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class b31575 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[M][N];
        for(int i=0;i<M;i++){
            String[] fields = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(fields[j]);
            }
        }

        visited = new boolean[M][N];
        System.out.println(bfs(0,0));
    }

    public static String bfs(int i, int j){
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];

            if(x==M-1 && y==N-1){
                return "Yes";
            }

            for(int a=0;a<2;a++){
                int nx = x + dx[a];
                int ny = y + dy[a];

                if(nx>=0 && nx<M && ny>=0 && ny<N && !visited[nx][ny]){
                    if(map[nx][ny] !=0){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return "No";
    }
}
