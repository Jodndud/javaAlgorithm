package 구현;

import java.io.*;
import java.util.*;

public class b10828 {

    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i=0;i<tc;i++){
            stack(br.readLine());
        }
    }

    private static void stack(String s) {
        // push면 숫자 추가
        if(s.contains("push")){
            String[] st = s.split(" ");
            int num = Integer.parseInt(st[1]);
            arrayList.add(num);
        } else{
            if(s.equals("top")){
                if (arrayList.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(arrayList.get(arrayList.size()-1));
                }
            } else if (s.equals("size")) {
                System.out.println(arrayList.size());
            } else if (s.equals("empty")){
                System.out.println(arrayList.isEmpty() ? 1 : 0);
            } else if (s.equals("pop")) {
                if (arrayList.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(arrayList.remove(arrayList.size()-1));
                }
            }
        }
    }
}
