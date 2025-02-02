package wooyeong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.parseInt(br.readLine());

        // start, mid, end 정해주기
        int start=0;
        int end=Arrays.stream(arr).max().orElseThrow();
        int mid = (start+end)/2;

        while(start<=end){
            int[] copyArr = Arrays.copyOf(arr, arr.length);
            // 배열에 중간값 만큼 할당하고 배열 합 확인
            for (int i = 0; i < n; i++) {
                if(copyArr[i] > mid) copyArr[i] = mid; // 110 120 120 120
            }
            int sum = Arrays.stream(copyArr).sum();

            if(sum>max){ // 배열 합이 max값보다 크면 end=mid-1 (왼쪽 탐색)
                end = mid-1;
            }else{
                start = mid+1; // 배열 합이 max보다 작으면 start=mid+1 (오른쪽 탐색)
            }

            // 정답일 경우 mid 추출
            mid = (start+end)/2;
        }

        System.out.println(mid);
    }
}
