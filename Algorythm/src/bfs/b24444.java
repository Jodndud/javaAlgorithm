package bfs;

import java.io.*;
import java.util.*;

public class b24444 {

    static int N, M, R;
    static ArrayList<ArrayList<Integer>> array;
    static int[] visited;
    static int count=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        visited = new int[N+1];

        // 간선 리스트 추가
        array = new ArrayList<>();
        for(int i=0;i<=N;i++){
            array.add(new ArrayList<>());
        }

        // 입력 노드 연결
        for(int i=0;i<M;i++){
            String[] nodes = br.readLine().split(" ");
            int a = Integer.parseInt(nodes[0]);
            int b = Integer.parseInt(nodes[1]);

            array.get(a).add(b);
            array.get(b).add(a);
        }

        // 노드 정렬
        for(int i=0;i<=N;i++){
            Collections.sort(array.get(i));
        }

//        System.out.println(array);

        // bfs 실행
        bfs(R);

        // visited배열 1부터 출력
        for(int i=1;i<visited.length;i++){
            System.out.println(visited[i]);
        }
    }

    private static void bfs(int R) {
        Queue<Integer> q = new LinkedList<>();

        q.add(R);
        visited[R] = count;

        while (!q.isEmpty()) {
            int node = q.poll();

            for(int j : array.get(node)){
                if(visited[j] == 0){
                    count++;
                    q.add(j);
                    visited[j] = count;
                }
            }
        }
    }
}
