package bfs;

import java.io.*;
import java.util.*;

public class b2178_1 {

    static int N, M;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNum = br.readLine().split(" ");
        N = Integer.parseInt(inputNum[0]);
        M = Integer.parseInt(inputNum[1]);

        // 인접 행렬 생성
        field = new int[N][M];
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split("");
            for(int j=0;j<M;j++){
                field[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited = new boolean[N][M];
        System.out.println(bfs(0,0, 1));
    }

    private static int bfs(int i, int j, int count) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j, count});
        visited[i][j] = true;

        while(!q.isEmpty()){
            int[] next = q.poll();
            int x = next[0];
            int y = next[1];
            int c = next[2];

            if(x==N-1 && y==M-1){
                return c;
            }

            for(int a=0; a<4; a++){
                int nx = x + dx[a];
                int ny = y + dy[a];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]){
                    if(field[nx][ny]==1){
                        q.add(new int[]{nx, ny, c+1});
                        visited[nx][ny] = true;
                    }
                }
            }

        }
        return -1;
    }
}
