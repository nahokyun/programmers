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
        int[] sum=new int[n+1];
        long count=0;
        Map<Integer,Integer> map=new HashMap<>();
        st=new StringTokenizer(br.readLine());
        
        for(int i=1;i<=n;i++){
            sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());
        }//end of input
        
        map.put(0,1);//처음을 위한 0

        for(int i=1;i<=n;i++){
            count+=map.getOrDefault(sum[i]-k,0);
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        
        System.out.println(count);
        
        
    }
}