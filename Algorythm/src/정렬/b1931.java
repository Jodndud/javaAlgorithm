package 정렬;

import java.io.*;
import java.util.*;

public class b1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<int[]> addArr = new ArrayList<>();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{a, b};
        }

        // 회의 종료시간 기준 정렬, 같으면 시작시간 기준 정렬
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1])
                .thenComparingInt(a -> a[0]));

        for(int[] next : arr){
            int start = next[0];
            int end = next[1];

            // 회의가 추가되있으면
            if(!addArr.isEmpty()){
                // addArr의 마지막 회의시간 조회
                int[] last = addArr.get(addArr.size()-1);

                // 다음회의 시작시간이 마지막 회의 종료시간 보다 크거나 같으면 추가
                if(last[1] <= start){
                    addArr.add(new int[]{start, end});
                }
            // 첫 회의 그냥 추가
            } else{
                addArr.add(new int[]{start, end});
            }
        }

//        for(int[] next: addArr){
//            System.out.println("(" + next[0] + "," + next[1] + ")");
//        }
        System.out.println(addArr.size());
    }
}