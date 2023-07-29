
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static int n;
    public static char[][] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        n=sc.nextInt();
        arr=new char[n][n];
        dfs(0,0,n);

        for(char[] i:arr){
            bw.write(i);
            bw.write('\n');
            bw.flush();
        }
    }

    private static void dfs(int startY,int startX,int n) {
        if(n==0)
            return;
        for(int i=startY;i<n;i++){
            for(int j=startX;j<n;j++){
                arr[i][j]='*';
            }
        }
        for(int i=startY+n/3;i<startY+2*n/3;i++){
            for(int j=startX+n/3;j<startX+2*n/3;j++){
                arr[i][j]=' ';
            }
        }
        dfs(startY,startX,n/3);
        dfs(startY,startX+n/3,n/3);
        dfs(startY,startX+2*n/3,n/3);
        dfs(startY+n/3,startX,n/3);
        dfs(startY+n/3,startX+n/3,n/3);
        dfs(startY+n/3,startX+2*n/3,n/3);
        dfs(startY+2*n/3,startX,n/3);
        dfs(startY+2*n/3,startX+n/3,n/3);
        dfs(startY+2*n/3,startX+2*n/3,n/3);
    }
}
