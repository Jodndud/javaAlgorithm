package 구현;

import java.io.*;
import java.util.*;

public class b2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int hap=0;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine()); // 배열에 할당
            hap += arr[i]; // 배열 합

            // 카운트맵 정의
            int count = countMap.getOrDefault(arr[i], 0) + 1;
            countMap.put(arr[i], count);
        }
        Arrays.sort(arr);

        // 산술평균
        // System.out.println("hap: " + hap);
        // System.out.println("hap/N: " + (float) hap/N);
        System.out.println(Math.round((float) hap/N));

        // 중앙값
        System.out.println(arr[((N-1)/2)]);

        // 최빈값: hash맵에서 value최대값 구하기
        // 2개 이상이면 두번째로 작은 수
        int maxValue = Collections.max(countMap.values());
        List<Integer> maxValueList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            if(entry.getValue() == maxValue){
                maxValueList.add(entry.getKey());
            }
        }
        Collections.sort(maxValueList);

        // System.out.println(maxValue);
        // System.out.println(maxValueList);

        if(maxValueList.size() >= 2){
            System.out.println(maxValueList.get(1));
        } else{
            System.out.println(maxValueList.get(0));
        }

        // 범위
        System.out.println(Math.abs(arr[N-1] - arr[0]));
    }
}
