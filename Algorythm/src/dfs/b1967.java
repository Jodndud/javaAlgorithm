package dfs;

import java.io.*;
import java.util.*;

public class b1967 {
    static int n;
    static ArrayList<int[]>[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 간선 크기 부여 (n+1개)
        array = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            array[i] = new ArrayList<>();
        }

        // 간선 데이터 채우기(양방향)
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            array[a].add(new int[]{b, cost});
            array[b].add(new int[]{a, cost});
        }

        int max = 0;
        // 모든 간선 가중치 합 구하기
        for(int i=1;i<=n;i++){
            for(int j=2;j<=n;j++){
                if(i<j){
                    max = Math.max(bfs(i, j), max);
                }
            }
        }
        System.out.println(max);
    }

    // start부터 end까지 (start < end)
    public static int bfs(int start, int end){
        boolean[] visited = new boolean[n+1]; // visited 초기화

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0}); // 노드와 합

        while(!q.isEmpty()){
            int[] next = q.poll();
            int node = next[0];
            int result = next[1];

            if(node == end){
                return result;
            }

            for(int[] j: array[node]){
                int nNode = j[0];
                int cost = j[1];

                if(!visited[nNode]){
                    q.add(new int[]{nNode, result + cost});
                    visited[nNode] = true;
                }
            }
        }

        return -1;
    }
}
