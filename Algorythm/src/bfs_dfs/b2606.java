package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class b2606 {

    static int n;
    static int node;
    static List<List<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        node = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        // 각 노드에 ArrayList를 만든다
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<>());
        }

        // 각 노드(지정)의 ArrayList에 원소를 집어넣는다.
        for(int i=0;i<node;i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            arr.get(x).add(y);
            arr.get(y).add(x);
        }


    }

}
