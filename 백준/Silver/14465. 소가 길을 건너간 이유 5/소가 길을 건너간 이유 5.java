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
        int k=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int[] blinker=new int[n+1];
        
        for(int i=0;i<b;i++){
            blinker[Integer.parseInt(br.readLine())]++;
        }
        int slide=0;
        for(int i=1;i<=k;i++){
            slide+=blinker[i];
        }
        int min=1000000;
        
        for(int i=k+1;i<=n;i++){
            if(blinker[i]==1){
                slide++;
            }
            if(blinker[i-k]==1){
                slide--;
            }
            min=Math.min(min,slide);
        }
        System.out.println(min);
        
    }
}