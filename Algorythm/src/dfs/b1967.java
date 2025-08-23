package dfs;

import java.io.*;
import java.util.*;

class Node{
    int node;
    int dist;

    public Node(int node, int dist) {
        this.node = node;
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

        int n = Integer.parseInt(br.readLine());

        // 트리 1~12번 노드 생성
        array = new ArrayList<>();
        for(int i=0;i<=n;i++){
            array.add(new ArrayList<>());
        }

        // 간선 연결
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            array.get(to).add(new Node(next, cost));
            array.get(next).add(new Node(to, cost));
        }
        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            dfs(i, 0);
        }
        System.out.println(max);
    }

    private static void dfs(int start, int result){
        visited[start] = true;
        max = Math.max(result, max);

        for(Node node : array.get(start)){
            if(!visited[node.node]){
                dfs(node.node, result + node.dist);
                visited[node.node] = false;
            }
        }
    }
}