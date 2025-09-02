package swea;

import java.util.*;
import java.io.*;

class 사과먹기
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] map = new int[N][N];
            int appleNum=0;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] != 0) {
                        appleNum++;
                    }
                }
            }

            int count=0;

            // 현위치
            int i=0;
            int j=0;

            // 현재 방향
            int x=0;
            int y=1;

            int num=1;
            // 사과 없으면 종료
            while(appleNum!=0) {
                // 현 위치 기다린 뒤 탐색(a,b가 대신이동)
                int a=i;
                int b=j;

                // 오른쪽 보기
                while(true) {
                    // 끝 도달하면 안봐도됨
                    if(a+y==N || a+y<0 || b-x==N || b-x<0) {
                        break;
                    }

                    // 이동
                    a+=y;
                    b-=x;

                    // num번 사과발견하면 회전 후 종료
                    if(map[a][b]==num) {
                        int temp=x;
                        x=y;
                        y=-temp;
                        count++;
                        break;
                    }
                }

                // 전진!!!
                // 다음칸 못가나 회전먼저 해라
                if(i+x==N || i+x<0 || j+y==N || j+y<0) {
                    int temp=x;
                    x=y;
                    y=-temp;
                    count++; // 회전수 기록
                }
                // 전진하기
                i+=x;
                j+=y;

                // 사과를 밟았다.
                if(map[i][j]==num){
                    appleNum--;
                    num++;
                    map[i][j]=0;
                }
            }
            System.out.println("#"+tc+" "+count);
        }
    }
}