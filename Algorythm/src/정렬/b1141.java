package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(br.readLine());
        }

        System.out.println(arr);
        Collections.sort(arr, (a, b) -> b.length() - a.length());

        ArrayList<String> answer = new ArrayList<>();

        for (String s : arr) {
            boolean isPrefix = false;
            for (String t : answer) {
                if (t.startsWith(s)) { // s가 t의 접두사라면 제외
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) {
                answer.add(s);
            }
        }

        System.out.println(answer.size());
    }
}
