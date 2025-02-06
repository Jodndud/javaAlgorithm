package wooyeong;

import java.util.*;
import java.io.*;

class B_1654{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];

        long start=1;
        long end=0;

        for(int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(end < arr[i]){
                end = arr[i];
            }
        }

        long result=0;

        while(start<end) {
            long mid = (start+end)/2;
            long sum=0; // sum 초기화

            // mid로 나누고 난 랜선 갯수를 다 더함
            for(int i=0;i<arr.length;i++) {
                sum += (arr[i] / mid);
            }

            // 필요갯수보다 적으면 더 작게 잘라야하니깐 end값 줄이기
            if(sum<n) end = mid;
            else{
                start = mid+1;
                result = mid;
            }

        }
        System.out.println(result);
    }
}
