package bfs;

import java.util.*;
import java.io.*;

public class b11060 {
    static ArrayList<Integer> array;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        array = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            array.add(Integer.parseInt(st.nextToken()));
        }

//        System.out.println(array);

        visited = new boolean[N];
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int i, int count){
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{i, count});
        visited[i] = true;

        while(!q.isEmpty()){
            int[] next = q.poll();
            int node = next[0];
            int cost = next[1];

            if(node == N-1){
                return cost;
            }

            for(int a=1;a<=array.get(node);a++){
                int nNode = node + a;

                if(nNode < N && !visited[nNode] && array.get(nNode) != 0){
                    q.add(new int[]{nNode, cost+1});
                    visited[nNode] = true;
                }
            }
        }
        return -1;
    }
}
