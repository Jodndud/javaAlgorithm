package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class b1987_1 {
    static int R, C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[] alpha = new boolean[26];
    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i=0;i<R;i++){
            String input = br.readLine();

            for(int j=0;j<C;j++){
                map[i][j] = input.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    static private int dfs(int i, int j, int count){
        max = Math.max(max, count);

        alpha[map[i][j] - 'A'] = true;

        for(int a=0;a<4;a++){
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx>=0 && nx<R && ny>=0 && ny<C && alpha[map[nx][ny] - 'A']){
                alpha[map[nx][ny] - 'A'] = true;
                dfs(nx, ny, count+1);
                alpha[map[nx][ny] - 'A'] = false;
            }
        }
        return count;
    }
}
