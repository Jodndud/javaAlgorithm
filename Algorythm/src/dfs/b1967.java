package dfs;

import java.io.*;
import java.util.*;

class Node{
    int to;
    int dist;

    public Node(int to, int dist) {
        this.to = to;
        this.dist = dist;
    }
}

public class b1967 {
    static int n;
    static ArrayList<ArrayList<Node>> array;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 간선 크기 부여 (n+1개)
        array = new ArrayList<>();
        for(int i=0;i<=n;i++){
            array.add(new ArrayList<>());
        }

        // 간선 데이터 채우기(양방향)
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            array.get(a).add(new Node(b, cost));
            array.get(b).add(new Node(a, cost));
        }

        // 모든 간선 가중치 합 구하기
        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            dfs(i, 0);
        }
        System.out.println(max);
    }

    static void dfs(int node, int dist){
        visited[node] = true;
        max = Math.max(max, dist);

        for(Node next: array.get(node)){
            if(!visited[next.to]){
                dfs(next.to, dist + next.dist);
            }
        }
    }
}
