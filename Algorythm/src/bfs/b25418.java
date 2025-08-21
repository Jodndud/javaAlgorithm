package bfs;

import java.io.*;
import java.util.*;

public class b25418 {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        visited = new boolean[K+1];
        System.out.println(bfs(A, K));
    }

    private static int bfs(int A, int K) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{A, 0});
        visited[A] = true;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int next = current[0];
            int count = current[1];

            if(next==K){
                return count;
            }

            if(next+1<=K && !visited[next+1]){
                visited[next+1] = true;
                q.add(new int[]{next+1, count+1});
            }

            if(next*2<=K && !visited[next*2]){
                visited[next*2] = true;
                q.add(new int[]{next*2, count+1});
            }
        }
        return -1;
    }
}
