import java.io.*;
import java.util.Arrays;

public class b2960 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int P = 0; // 아직 지우지 않은 수 중 최소
        int count = 0;

        // 2부터 N까지 크기 N인 배열 생성
        int[] arr = new int[N+1];
        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }
        arr[0] = 0;
        arr[1] = 0;

        while(count < K){
            // 아직 지우지 않은 수 중 가장 작은 수 P
            for(int i=0;i<=arr.length;i++){
                if(arr[i] != 0){
                    P = arr[i];
                    break;
                }
            }

            // P의 배수 삭제
            for(int i=1;i<arr.length;i++){
                if(P*i < arr.length && arr[P*i] != 0){
                    int result = arr[P*i];
                    arr[P*i] = 0;
                    count++;
                    if(count == K){
                        System.out.println(result);
                        break;
                    }
                }
            }
        }
    }
}