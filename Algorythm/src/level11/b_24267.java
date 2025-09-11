package level11;

import java.util.Scanner;

public class b_24267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum=0;
        int count=0;
        for(int i=1;i<=n-2;i++){
            for(int j=i+1;j<=n-1;j++){
                for(int k=j+1;k<=n;k++){
                   sum+= i*j*k;
                   count++;
                }
            }
        }

        System.out.println(count);
        System.out.println((long) n*(n-1)*(n-2)/6);
        System.out.println(3);
    }
}
