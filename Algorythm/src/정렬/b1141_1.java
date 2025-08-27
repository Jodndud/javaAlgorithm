package 정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b1141_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            arr.add(br.readLine());
        }

        Collections.sort(arr, (x, y) -> y.length() - x.length());

        ArrayList<String> sortArr = new ArrayList<>();

        for(String x : arr){
            boolean is_same = false;
            for(String y : sortArr){
                if(y.startsWith(x)){ // x로 시작하는가? 종료
                    is_same = true;
                    break;
                }
            }

            // x로 시작 안하는 거 추가
            if(!is_same) {
                sortArr.add(x);
            }
        }

        System.out.println(sortArr.size());
    }
}
