package dfs;

import java.io.*;
import java.util.*;

class Node{
<<<<<<< HEAD
    int node;
    int dist;

    public Node(int node, int dist) {
        this.node = node;
=======
    int to;
    int dist;

    public Node(int to, int dist) {
        this.to = to;
>>>>>>> 1b4b88b0c15cbd9cec09ae0218f3e40591680308
        this.dist = dist;
    }
}

public class b1967 {
<<<<<<< HEAD

    static ArrayList<ArrayList<Node>> array;
    static boolean[] visited;
    static int max=0;
=======
    static int n;
    static ArrayList<ArrayList<Node>> array;
    static boolean[] visited;
    static int max = 0;
>>>>>>> 1b4b88b0c15cbd9cec09ae0218f3e40591680308

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

<<<<<<< HEAD
        // 트리 1~12번 노드 생성
=======
        // 간선 크기 부여 (n+1개)
>>>>>>> 1b4b88b0c15cbd9cec09ae0218f3e40591680308
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

<<<<<<< HEAD
            array.get(to).add(new Node(next, cost));
            array.get(next).add(new Node(to, cost));
        }

=======
            array.get(a).add(new Node(b, cost));
            array.get(b).add(new Node(a, cost));
        }

        // 모든 간선 가중치 합 구하기
>>>>>>> 1b4b88b0c15cbd9cec09ae0218f3e40591680308
        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            dfs(i, 0);
        }
        System.out.println(max);
    }

<<<<<<< HEAD
    private static void dfs(int start, int result){
        visited[start] = true;
        max = Math.max(result, max);

        for(Node node : array.get(start)){
            if(!visited[node.node]){
                dfs(node.node, result + node.dist);
                visited[node.node] = false;
=======
    static void dfs(int node, int dist){
        visited[node] = true;
        max = Math.max(max, dist);

        for(Node next: array.get(node)){
            if(!visited[next.to]){
                dfs(next.to, dist + next.dist);
>>>>>>> 1b4b88b0c15cbd9cec09ae0218f3e40591680308
            }
        }
    }
}