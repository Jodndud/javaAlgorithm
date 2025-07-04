import java.io.*;

public class b1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = 0;
        int tc = Integer.parseInt(br.readLine());
        for(int i=0;i<tc;i++){
            if(group()) count++;
        }
        System.out.println(count);
    }

    public static boolean group() throws IOException {
        String[] words = br.readLine().split("");

        boolean[] check = new boolean[26];
        int prev=-1;

        for(String word : words){
            int result = (int) word.charAt(0) - (int) 'a';  // 문자를 아스키코드로 변환

            if (result != prev){  // 나왔던 아스키 코드인지?
                if(!check[result]){
                    check[result] = true;
                    prev = result;
                }else return false;
            }
            // 나오지 않았던 아스키 코드면 돌 필요가 없다. 연결 되니깐
        }

        return true;
    }
}