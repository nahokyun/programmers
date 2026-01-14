//@@@@@@IMOS 알고리즘
//@@@@@@
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        char[][] map=new char[n+1][m+1];
        int[][] prefixSumB=new int[n+1][m+1];
        int[][] prefixSumW=new int[n+1][m+1];
        int min=1_000_000_000;
        
        for(int i=1;i<=n;i++){
            String input=br.readLine();
            for(int j=1;j<=m;j++){
                map[i][j]=input.charAt(j-1);
                if((i+j)%2==0){
                    prefixSumB[i][j]=map[i][j]=='B'?0:1;
                    prefixSumW[i][j]=map[i][j]=='W'?0:1;
                }else{
                    prefixSumB[i][j]=map[i][j]=='W'?0:1;
                    prefixSumW[i][j]=map[i][j]=='B'?0:1;
                }
            }
        }//입력 및 누적합의 수정여부 체크
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                prefixSumB[i][j]=prefixSumB[i-1][j]+prefixSumB[i][j];
                prefixSumW[i][j]=prefixSumW[i-1][j]+prefixSumW[i][j];
            }
        }
        for(int i=0;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefixSumB[i][j]=prefixSumB[i][j-1]+prefixSumB[i][j];
                prefixSumW[i][j]=prefixSumW[i][j-1]+prefixSumW[i][j];
            }
        }//누적합 계산
        
        for(int i=k;i<=n;i++){
            for(int j=k;j<=m;j++){
                int b=prefixSumB[i][j]-(prefixSumB[i-k][j]+prefixSumB[i][j-k])+prefixSumB[i-k][j-k];
                int w=prefixSumW[i][j]-(prefixSumW[i-k][j]+prefixSumW[i][j-k])+prefixSumW[i-k][j-k];
                min=Math.min(w,Math.min(b,min));
            }
        }
        
        System.out.println(min);
    }
}