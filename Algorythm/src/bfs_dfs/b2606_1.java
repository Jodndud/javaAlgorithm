package bfs_dfs;

import java.io.*;
import java.util.*;

public class b2606_1 {

    static ArrayList<ArrayList<Integer>> array;
    static boolean[] visited;
    static int count =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());

        // 간선리스트 생성(노드 수 만큼 리스트 만들기)
        array = new ArrayList<>();
        for(int i=0;i<=node;i++){
            array.add(new ArrayList<>());
        }

        for(int i=0;i<line;i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // a번째 간선(get)에 b연결(add)
            array.get(a).add(b);
            array.get(b).add(a);
        }

        visited = new boolean[node+1];
        System.out.println(bfs(1));
    }

    private static int bfs(int i) {
        Queue<Integer> q = new LinkedList<>();

        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int x : array.get(node)){
                if(!visited[x]){
                    q.add(x);
                    visited[x] = true;
                    count++;
                }
            }
        }
        return count;
    }
}