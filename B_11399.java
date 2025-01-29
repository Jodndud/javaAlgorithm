package baekjoon;

import java.util.*;

public class B_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int[] sumArr = new int[N];
        while(N>0){
            int sum=0;
            for (int i = 0; i < N; i++) {
                sum += arr[i];
            }
            sumArr[N-1] = sum;
            N--;
        }

        int sum=0;
        for (int i : sumArr) {
            sum+=i;
        }
        System.out.println(sum);
    }
}
