package 정렬;

import java.io.*;
import java.util.*;

public class b11497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int a=0;a<tc;a++){
            int n = Integer.parseInt(br.readLine());

            int[] result = new int[n];
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 정렬하고
            Arrays.sort(arr);

            int left=0;
            int right=1;
            // 하나씩 처음과 끝에 각각 배치
            for (int i=0;i<n;i++) {
                if(i%2==0){
                    result[left] = arr[i];
                    left++;
                }else{
                    result[n-right] = arr[i];
                    right++;
                }
            }

            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(result));
            int max=0;
            for(int i=0;i<n;i++){
                if(i==0){
                    max = Math.max(max, Math.abs(result[i] - result[n-1]));
                } else {
                    max = Math.max(max, Math.abs(result[i] - result[i-1]));
                }
            }
            System.out.println(max);
        }
    }
}
