### 알고리즘 공부법 : https://openingsound.tistory.com/117

# DFS/BFS
[(이코테 2021 강의 몰아보기) 2. 그리디 & 구현](https://www.youtube.com/watch?v=2zjoKjt97vQ&list=PLRx0vPvlEmdAghTr5mXQxGpHjWqSz0dgC&index=2)

백트래킹 : 



# 이진 탐색

<br>

# 다이나믹 프로그래밍(DP)
`큰 문제`를 `작은 문제`로 나눌 수 있을 때.<br>
`작은 문제의 답을 모아`서 큰 문제를 해결할 수 있는 상황일 때.

`탑다운` 방식과 `보텀업`으로 구성<br>
ex)피보나치 수열
```java
// 보텀업 방식
import java.util.*

public class Main{
    public static long[] d = new long[100];

    publit static void main(String[] args){
        d[1] = 1;
        d[2] = 1;
        int n = 50;

        for (int i = 3; i<=n; i++){
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }
}
```
