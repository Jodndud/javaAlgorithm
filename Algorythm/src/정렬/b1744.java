package 정렬;

import java.io.*;
import java.util.*;

public class b1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder()); // 양수 내림차순 3 2 1
        PriorityQueue<Integer> minus = new PriorityQueue<>(); // 음수 오름차순  -3 -2 -1 0
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x <= 0) minus.add(x);
            else plus.add(x);
        }

        int answer=0;
        // 음수일때 최대값구하기 -3 -2 -1 0
        while (!minus.isEmpty()) {
            int cur = minus.poll();
            if (minus.isEmpty()) { // 마지막일 때 더하기
                answer += cur;
                break;
            }
            if(minus.peek() == 0){ // 다음 남은 값 0?
                minus.poll();
            } else {
                answer += cur * minus.poll(); // 둘다 음수면 곱한값 더하기
            }
        }

        // 양수일때 최대값구하기 4 3 2 1
        while (!plus.isEmpty()) {
            int cur = plus.poll();
            if (plus.isEmpty()) { // 마지막일 때 더하기
                answer += cur;
                break;
            }
            if (cur ==1){
                answer += 1;
            }else if(plus.peek() == 1){
                answer += cur + plus.poll();
            }else{
                answer += cur * plus.poll();
            }
        }

        System.out.println(answer);
    }
}
