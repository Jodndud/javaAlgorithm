package bfs;

import java.io.*;
import java.util.*;

public class b2644 {
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> array;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());

        // 노드 수만큼 인접리스트 생성
        array = new ArrayList<>();
        for(int i=0;i<=n;i++){
            array.add(new ArrayList<>());
        }

        // 노드 연결
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array.get(a).add(b);
            array.get(b).add(a);
        }

        visited = new boolean[n+1];
        System.out.println(bfs(r1, r2, 0));
    }

    private static int bfs(int r1, int r2, int count) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{r1, count});
        visited[r1] = true;

        while(!q.isEmpty()){
            int[] next = q.poll();
            int node = next[0];
            int cost = next[1];

            if(node == r2){
                return cost;
            }

            for(int j: array.get(node)){
                if(!visited[j]){
                    q.add(new int[]{j, cost+1});
                    visited[j] = true;
                }
            }
        }
        return -1;
    }
}
