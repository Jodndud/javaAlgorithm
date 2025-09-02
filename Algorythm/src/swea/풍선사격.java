package swea;

import java.io.*;
import java.util.*;

public class 풍선사격 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }

            int result=0;
            while(!arr.isEmpty()){
                // 최댓값 초기화
                int max=0;
                // 최댓값일 때 idx 초기화
                int idx=1000000;

                // 최댓값이 같으면 index는 작은거 터뜨려
                for(int i=0;i<arr.size();i++){
                    if(arr.size()==1){
                        max=arr.get(i);
                        idx=i;
                    }
                    if(arr.size()==2){
                        if(i==0){
                            max=arr.get(1);
                            idx=i;
                        }else{
                            if(max<=arr.getFirst()){
                                if(max==arr.getFirst()){
                                    max=arr.getFirst();
                                    idx = Math.min(idx, i);
                                    continue;
                                }
                                max=arr.getFirst();
                                idx = 0;
                            }
                        }
                    }
                    if(arr.size()>2){
                        if(i==0){
                            max=arr.get(1);
                            idx=i;
                        }
                        if(i==arr.size()-1){
                            if(max<=arr.get(i-1)){
                                if(max==arr.get(i-1)){
                                    max = arr.get(i-1);
                                    idx = Math.min(idx, i);
                                    continue;
                                }
                                max = arr.get(i-1);
                                idx = i;
                            }
                        }
                        if(i>0 && i<arr.size()-1){
                            if(max<= arr.get(i-1)*arr.get(i+1)){
                                if(max==arr.get(i-1)*arr.get(i+1)){
                                    max = arr.get(i-1)*arr.get(i+1);
                                    idx = Math.min(idx, i);
                                    continue;
                                }
                                max = arr.get(i-1)*arr.get(i+1);
                                idx = i;
                            }
                        }

                    }
                }

                // 다돌아 봤으면 최대값 누적, idx값 삭제
                result+=max;
                arr.remove(idx);
            }

            System.out.println("#"+tc+" "+result);
        }
    }
}
