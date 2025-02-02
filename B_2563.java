package wooyeong;

import java.io.*;
import java.util.StringTokenizer;

public class B_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] graph = new int[100][100];

        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 가로x세로 10인 색종이 +1
            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    graph[j][k]++;
                }
            }
        }

        int count=0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if(graph[i][j]!=0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
