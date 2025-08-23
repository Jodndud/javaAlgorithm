package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int[] sortArray = new int[N];
        for(int i=0;i<N;i++){
            array[i] = Integer.parseInt(st.nextToken());
            sortArray[i] = array[i];
        }

        Arrays.sort(sortArray);
        System.out.println(Arrays.toString(sortArray));

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for(int value : sortArray){
            if(!rankMap.containsKey(value)){
                rankMap.put(value, rank++);
            }
        }




    }
}