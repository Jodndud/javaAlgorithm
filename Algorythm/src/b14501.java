import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class b14501 {
    static int max = 0;
    static int tc;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        arr = new int[tc][2];
        for(int i=0;i<tc;i++){
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        cal(0, 0);
        System.out.println(max);
    }

    private static void cal(int day, int sum) {
        if(day >= tc){
            max = Math.max(max, sum);
            return;
        }

        // 상담한다
        if(day + arr[day][0] <= tc){
            cal(day + arr[day][0], sum + arr[day][1]);
        }
        // 안한다
        cal(day+1, sum);
    }
}