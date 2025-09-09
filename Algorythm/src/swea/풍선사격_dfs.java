package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 풍선사격_dfs {
    static int N;
    static ArrayList<Integer> arr;
    static int result;

    private static void game(int sum, ArrayList<Integer> arr){
        // 종료조건
        if(arr.size()==1){
            result = Math.max(result, sum + arr.getFirst());
            return;
        }

        int value = 0;
        for(int i=0;i<arr.size();i++){
            if(i==0){
                value = arr.get(1);
            }else if(i==arr.size()-1){
                value = arr.get(arr.size()-2);
            }else{
                value = arr.get(i-1)*arr.get(i+1);
            }

            int removed = arr.remove(i);
            game(sum + value , arr);
            arr.add(i, removed);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new ArrayList<>();
            for(int j=0;j<N;j++){
                arr.add(Integer.parseInt(st.nextToken()));
            }

            result = 0;
            game(0, arr);
            System.out.println("#"+ i+1 + " "+ result);
        }
    }
}
