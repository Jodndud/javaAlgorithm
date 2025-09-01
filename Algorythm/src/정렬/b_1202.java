package 정렬;

import java.io.*;
import java.util.*;

public class b_1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dia = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            dia[i][0] = Integer.parseInt(st.nextToken());
            dia[i][1] = Integer.parseInt(st.nextToken());
        }

        // 가격순으로 내림차순
        Arrays.sort(dia, (x, y) -> (x[0]==y[0]) ? y[1]-x[1] : x[0]-y[0]);

        PriorityQueue<Integer> bag = new PriorityQueue<>();
        for(int i=0;i<K;i++){
            int x = Integer.parseInt(br.readLine());
            bag.add(x);
        }

        // 가격이 높은 보석을 담기 위한 max-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long result = 0;
        int idx = 0;
        for (int i : bag) {
            // 현재 가방에 담을 수 있는 보석을 pq에 추가
            while (idx < N && dia[idx][0] <= i) {
                pq.add(dia[idx][1]); // 가격
                idx++;
            }

            // 가장 비싼 보석을 담음
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
