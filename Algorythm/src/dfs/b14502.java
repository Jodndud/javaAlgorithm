package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
    int x;
    int y;

    public Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class b14502 {
    static int N, M;
    static int[][] map;
    static int max=0;

    private static int bfs(){
        // 맵 복제
        int[][] copyMap = new int[N][M];
        for(int i=0;i<N;i++){
            copyMap[i] = map[i].clone();
        }

        Queue<Virus> q = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 바이러스 q에 저장
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copyMap[i][j] == 2){
                    q.add(new Virus(i, j));
                }
            }
        }

        // 바이러스 전파
        while(!q.isEmpty()){
            Virus next = q.poll();

            for(int a=0;a<4;a++){
                int nx = next.x + dx[a];
                int ny = next.y + dy[a];

                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(copyMap[nx][ny] == 1 || copyMap[nx][ny] == 2) continue;
                    if(copyMap[nx][ny] == 0){
                        copyMap[nx][ny] = 2;
                        q.add(new Virus(nx, ny));
                    }
                }
            }
        }

        // 안전영역 계산
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copyMap[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int wall){
        // 벽 다 세우면 안전 영역 계산
        if(wall == 3){
            max = Math.max(max, bfs());
            return;
        }

        // 벽 세우기
        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                if(map[a][b]==0){ // 빈 칸에 세우기
                    map[a][b] = 1;
                    dfs(wall+1);
                    map[a][b] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }
}