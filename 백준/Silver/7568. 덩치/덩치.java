import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class HW {
        int h;
        int w;
        public HW(int h,int w){
            this.h=h;
            this.w=w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        HW[] arr=new HW[n];
        int[] result=new int[n];
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            arr[i]=new HW(y,x);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                if(arr[j].w>arr[i].w&&arr[j].h>arr[i].h)
                    result[i]++;
            }
        }
        
        for(int i=0;i<n;i++){
            sb.append(result[i]+1).append(' ');
        }
        
        System.out.println(sb);
    }
}