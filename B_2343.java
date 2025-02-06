package wooyeong;

import java.io.*;
import java.util.*;

public class B_2343 {
    static int[] arr;
    static int low, high, sum;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            low = Math.min(low,arr[i]);
        }
        high = sum;

        System.out.println(findMinLength());
    }

    private static int findMinLength() {
        int result =0;

        while(low<=high) {
            int mid = (low + high) / 2;

            int count = 1;
            sum=0;

            for (int i = 0; i < N; i++) {
                if(sum + arr[i] > mid){
                    count++;
                    sum = arr[i];
                }else{
                    sum += arr[i];
                }
            }

            if(count <= M){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }
}
