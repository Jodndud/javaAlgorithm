package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b1141 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> arr = new ArrayList<>();
        // 입력 받은 배열(기본)
        for(int i=0;i<n;i++){
            arr.add(br.readLine());
        }

        int count=0;
        // 부분집합
        // 백트래킹으로 구현


        // 비트연산자
        for(int mask=0;mask<(1<<n);mask++){
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // i번째 비트가 1이면 포함
                    result.add(arr.get(i));
                }
            }

            // 속하는지 판단
            for(int i=0;i<result.size();i++){
                if(){
                    count++;
                }
            }
        }
    }
}
