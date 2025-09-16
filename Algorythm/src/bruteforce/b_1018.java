package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class b_1018 {
    static int N, M;
    static boolean[][] map;
    static int result = 64;

    private static void chessMap(int x, int y){
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        // 첫 번째 칸의 색
        boolean TF = map[x][y];

        for(int i=x;i<end_x;i++){
            for( int j=y;j<end_y;j++){
                // 색이 다를경우 1 증가
                if(map[i][j] != TF){
                    count++;
                }
                // 다음 칸 색 바꿔서 비교
                TF = (!TF);
            }

            TF = !TF;
        }

        count = Math.min(count, 64-count);
        result = Math.min(result, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++) {
                if(input.charAt(j) == 'W'){
                    map[i][j] = true;
                }else{
                    map[i][j] = false;
                }
            }
        }

        for(int i=0;i<N-7;i++){
            for(int j=0;j<M-7;j++){
                chessMap(i, j);
            }
        }
        System.out.println(result);
    }
}
