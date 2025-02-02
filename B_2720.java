package wooyeong;

import java.util.Scanner;

public class B_2720 {
    static int[] coin = new int[]{25,10,5,1};

    public static void main(String[] args){
        Scanner br = new Scanner(System.in);
        int T = br.nextInt();

        for (int i = 0; i < T; i++) {
            int[] coinNum = new int[coin.length];
            int price = br.nextInt();

            for (int j = 0; j < coin.length; j++) {
                if(price/coin[j] != 0){
                    coinNum[j] = price/coin[j];
                    price = price%coin[j];
                }
                System.out.print(coinNum[j] + " ");
            }
        }
    }
}
