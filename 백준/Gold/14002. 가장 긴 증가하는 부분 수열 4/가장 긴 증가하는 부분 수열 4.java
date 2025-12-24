import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        int[] arrIdx=new int[n];//arr를 이분탐색했을때 들어가는 idx저장
        int[] dp=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dp[0]=arr[0];
        int idx=0;
        for(int i=1;i<n;i++){
            if(arr[i]>dp[idx]){
                dp[++idx]=arr[i];
                arrIdx[i]=idx;
                continue;
                
            }
            int left=-1;
            int right=idx;
            
            while(left+1<right){
                int mid=(left+right)>>1;
                if(dp[mid]<arr[i]){
                    left=mid;
                }else{
                    right=mid;
                }
                
            }
            arrIdx[i]=right;
            dp[right]=arr[i];
        }
        
        //결과 출력
        StringBuilder sb=new StringBuilder();
        sb.append(idx+1).append('\n');
        
        int[] result=new int[n];
        int curIdx=idx;
        int c=0;
        
        for(int i=n-1;i>=0;i--){
            if(arrIdx[i]==curIdx){
                result[curIdx]=arr[i];
                curIdx--;
            }
        }
        for(int i=0;i<=idx;i++){
            sb.append(result[i]).append(' ');
        }
        
        System.out.println(sb);
    }//end of main

}
