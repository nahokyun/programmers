import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[] test=new int[t];
        int max=0;
        StringBuilder sb=new StringBuilder();
        long[] arr=new long[1000001];
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;
        
        for(int i=0;i<t;i++){
            test[i]=Integer.parseInt(br.readLine());
            max=Math.max(test[i],max);
        }
        
        for(int i=4;i<=max;i++){
            arr[i]=(arr[i-3]+arr[i-2]+arr[i-1])%1_000_000_009;
        }
        
        for(int i=0;i<t;i++){
            sb.append(arr[test[i]]).append('\n');
        }
        System.out.println(sb);
    }
}