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
        int[] sum=new int[1000001];
        int min=1000001;
        int max=-1;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            min=Math.min(min,s);
            max=Math.max(max,e);
            sum[s]++;
            sum[e]--;
            //누적합 적용할 좌표 표시
        }
        for(int i=min+1;i<=max;i++){
            sum[i]=sum[i-1]+sum[i];
        }//누적합 적용
        
        
        int left=min;
        int right=min;
        int cur=0;
        while(right<=max){
            if(cur<k){
                cur=cur+sum[right++];
            }else if(cur>k){
                cur=cur-sum[left++];
            }else{
                if(left==min)
                    left=0;
                System.out.println(left+" "+right);
                return;
            }
        }
        System.out.println("0 0");
        
        
        
    }

}