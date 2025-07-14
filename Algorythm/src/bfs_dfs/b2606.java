package bfs_dfs;

import java.io.*;
import java.util.*;

public class b2606 {

    static ArrayList<ArrayList<Integer>> array;
    static boolean[] visited;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine());
        int cost = Integer.parseInt(br.readLine());

        // 간선리스트 생성(노드 수 만큼 리스트 만들기)
        array = new ArrayList<>();
        for(int i=0;i<=node;i++){
            array.add(new ArrayList<>());
        }

        // 각 노드의 리스트 만들기
        for(int i=0;i<cost;i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            array.get(x).add(y);
            array.get(y).add(x);
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

            for (int j : array.get(node)) {
                if(!visited[j]){
                    q.add(j);
                    visited[j] = true;
                    count++;
                }
            }
        }

        return count;
    }

}
