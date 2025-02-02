package wooyeong;

import java.util.Scanner;

public class B_2903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int start = 2;
        int result = 0;
        for (int i = 0; i < n; i++) {
            start = start+(start-1);
            result = (int) Math.pow(start,2);
        }

        System.out.println(result);
    }
}
