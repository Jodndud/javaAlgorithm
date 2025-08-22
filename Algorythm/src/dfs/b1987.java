package dfs;

import java.io.*;
import java.util.*;

public class b1987 {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] alpha;
    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j);
            }
        }

        alpha = new boolean[26];
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int i, int j, int count){
        max = Math.max(max, count);

        alpha[map[i][j] - 'A'] = true;

        for(int a=0;a<4;a++){
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx>=0 && nx<N && ny>=0 && ny<M && !alpha[map[nx][ny] - 'A']){
                alpha[map[nx][ny] - 'A'] = true;
                dfs(nx, ny, count+1);
                alpha[map[nx][ny] - 'A'] = false;
            }
        }
    }
}