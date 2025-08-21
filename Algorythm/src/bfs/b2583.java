package bfs;

import java.io.*;
import java.util.*;

public class b2583 {

    static int M;
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count=0;
    static ArrayList<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        visited = new boolean[N][M];
        map = new int[N][M];
        for(int i=0;i<K;i++){
           String[] square = br.readLine().split(" ");
           int xS = Integer.parseInt(square[0]);
           int yS = Integer.parseInt(square[1]);
           int xE = Integer.parseInt(square[2]);
           int yE = Integer.parseInt(square[3]);
           // 0 2 4 4 채워넣기 -> 2~4 다 채우면 한 칸을 더 채워버림
            // (0,2) (0,3) (0,4)
            // (1,2) (1,3) (1,4)
            // (2,2) (2,3) (2,4)
            // (3,2) (3,3) (3,4)
            // (4,2) (4,3) (4,4)
           for(int j=xS;j<xE;j++){
               for(int k=yS;k<yE;k++){
                   map[j][k]++;
               }
           }
        }

//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        // map을 돌면서 bfs처리
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0){
                    areaList.add(bfs(i, j));
                }
            }
        }
        System.out.println(areaList.size());

        Collections.sort(areaList);
        for(int i : areaList){
            System.out.print(i + " ");
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int area=1;

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] next = q.poll();
            int ni = next[0];
            int nj = next[1];

            for(int a=0;a<4;a++){
                int nx = ni + dx[a];
                int ny = nj + dy[a];

                if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]){
                    if(map[nx][ny] == 0){
                        area++;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        map[nx][ny] = 1;
                    }
                }
            }
        }

        return area;
    }
}
