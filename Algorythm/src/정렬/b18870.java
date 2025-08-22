package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> dic = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for(int i=0;i<N;i++){
            array[i] = Integer.parseInt(st.nextToken());
            dic.put(array[i], 0); // value 0으로 초기화
        }

        // 복제 배열 생성
        int[] sorted = array.clone();

        // 복제해서 Set으로 변환
        Arrays.sort(sorted);

        for(int i=0;i<N;i++){
            System.out.print(array[i] + " ");
        }
    }
}