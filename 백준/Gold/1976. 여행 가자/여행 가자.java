import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());

        int[][] map=new int[n+1][n+1];
        int[][] dist=new int[n+1][n+1];
        int[] seq=new int[m];
        for(int i=1;i<=n;i++){
            Arrays.fill(map[i],5000000);
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                int tmp=Integer.parseInt(st.nextToken());
                if(i==j){
                    map[i][j]=0;
                    continue;
                }
                if(tmp==1){
                    map[i][j]=1;
                }
            }
        }

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }
        //입력 종료

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    map[i][j]=Math.min(map[i][k]+map[k][j],map[i][j]);
                }
            }
        }


        for(int i=1;i<m;i++){
            if(map[seq[i]][seq[i-1]]>=5000000){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");


    }
}