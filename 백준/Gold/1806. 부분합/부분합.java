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
        int s=Integer.parseInt(st.nextToken());
        boolean flag=false;
        int left=0;
        int right=0;
        int result=10000000;
        long[] sum=new long[n+1];
        st=new StringTokenizer(br.readLine());
        sum[1]=Integer.parseInt(st.nextToken());
        if(!flag&&sum[1]>=s){
            right=1;
            flag=true;
        }
        
        for(int i=2;i<=n;i++){
            sum[i]=Integer.parseInt(st.nextToken())+sum[i-1];
            if(!flag&&sum[i]>=s){
                right=i;
                flag=true;
            }
        }
        
        if(right==0){
            result=0;
        }else{
            while(right<=n){
                //System.out.println(sum[right]-sum[left]+" "+right+" "+left);
                if(sum[right]-sum[left]<s){
                    right++;
                }else{
                    result=Math.min(result,right-left);
                    left++;
                }
            }
        }
        
        
        System.out.println(result);
    }
}