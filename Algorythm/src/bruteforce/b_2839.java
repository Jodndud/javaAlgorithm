package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count=0;

        while(N>0){
            if(N%5 == 0){
                count += N/5;
                System.out.println(count);
                return;
            }
            if(N<3){
                System.out.println(-1);
                return;
            }
            N-=3;
            count++;
        }
        System.out.println(count);
    }
}
