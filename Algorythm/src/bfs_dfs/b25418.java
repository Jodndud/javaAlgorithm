package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class b25418 {

    static int A;
    static int K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        visited = new boolean[K+1];

        System.out.println(bfs(A));
    }

    private static int bfs(int start) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()){
            int[] next = q.poll();
            int value = next[0];
            int step = next[1];

            // 종료조건
            if(value == K){
                return step;
            }

            // 연산1
            if(value + 1 <=K && !visited[value+1]){
                visited[value+1] = true;
                q.add(new int[]{value+1, step+1});
            }
            // 연산2
            if(next[0]*2 <=K && !visited[value*2]){
                visited[value*2] = true;
                q.add(new int[]{value*2, step+1});
            }
        }
        return -1;
    }
}
