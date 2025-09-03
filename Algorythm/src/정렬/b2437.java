package 정렬;

import java.io.*;
import java.util.*;

public class b2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 1 1 2 3 6 7 30
        int result=0;
        for(int i=0;i<N;i++){
            if(result+1 > arr[i]){
                result+=arr[i];
            }
        }
        System.out.println(result+1);
    }
}
