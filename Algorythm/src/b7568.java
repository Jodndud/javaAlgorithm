import java.io.*;

public class b7568 {

    static int tc;
    static int[][] personInfo;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        personInfo = new int[tc][2];
        for(int i=0;i<tc;i++){
            String[] info = br.readLine().split(" ");
            personInfo[i][0] = Integer.parseInt(info[0]);
            personInfo[i][1] = Integer.parseInt(info[1]);
        }

        rank = new int[tc];
        for(int i=0;i<tc;i++){
            for(int j=0;j<tc;j++){
                if(i==j) continue;
                if(personInfo[i][0] < personInfo[j][0] && personInfo[i][1] < personInfo[j][1]) {
                    rank[i]++;
                }
            }
        }

        for(int i : rank){
            System.out.print(i+1 + " ");
        }
    }
}
