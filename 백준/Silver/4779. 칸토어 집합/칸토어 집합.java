
import java.io.*;
import java.util.Arrays;

public class Main {
    public static int n;
    public static char[] arr;
    public static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while((input=br.readLine())!=null){
            n= Integer.parseInt(input);
            size=(int) Math.pow(3,n);
            arr=new char[size];
            Arrays.fill(arr,'-');
            dfs(0,size);

            bw.write(arr);
            bw.write("\n");
            bw.flush();
        }

    }
    private static void dfs(int startX, int n){
        if(n==0)
            return;
        for(int i=startX+n/3;i<startX+2*n/3;i++){
            arr[i]=' ';
        }
        dfs(startX,n/3);
        dfs(startX+2*n/3,n/3);
    }
}
