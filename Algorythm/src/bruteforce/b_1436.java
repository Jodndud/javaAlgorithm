package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int end = 666;
        int count =1;

        while(count != N){
            end++;

            if(String.valueOf(end).contains("666")){
                count++;
            }
        }
        System.out.println(end);
    }
}
