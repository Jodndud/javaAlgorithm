package wooyeong;

import java.io.*;
import java.util.*;

public class B_2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 1;
        int end = arr[N-1]-arr[0];
        int result = 0;

        while(start<=end){
            int mid = (start+end)/2;
            int count = 1; // 첫 집에 설치
            int pin = start;

            for (int i = 1; i < N; i++) {
                if(arr[i]-pin>=mid){
                    count++;
                    pin = arr[i];
                }
            }

            if(count<C){
                end=mid-1;
            }else{
                result = mid;
                start=mid+1;
            }
        }

        System.out.println(result);
    }
}
