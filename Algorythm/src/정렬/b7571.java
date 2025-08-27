package 정렬;

import java.io.*;
import java.util.*;

public class b7571 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] xList = new int[m];
        int[] yList = new int[m];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            xList[i] = Integer.parseInt(st.nextToken());
            yList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xList);
        Arrays.sort(yList);

        int xMid = xList[m/2];
        int yMid = yList[m/2];

        int ans = 0;
        for(int i=0;i<m;i++){
            ans += Math.abs(xMid-xList[i]) + Math.abs(yMid-yList[i]);
        }
        System.out.println(ans);
    }
}
