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
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(st.nextToken());
		}//입력 종료
        
        int[] longestArr=new int[n+1];
        int[] dp=new int[n];//각각의 숫자가 어느 포지션에 들어갔는지 저장
        longestArr[0]=arr[0];
        
        int idx=0;
        for(int i=1;i<n;i++){
            int cur=arr[i];
            
            if(cur>longestArr[idx]){
                longestArr[++idx]=cur;
                dp[i]=idx;
            }else{
                int left=0;
                int right=idx;
                while(left<right){
                    int mid=(left+right)>>1;
                    if(longestArr[mid]>=cur){
                        right=mid;
                    }else{
                        left=mid+1;
                    }
                }
                longestArr[right]=cur;
                dp[i]=right;
            }//이분탐색 종료
        }//for문 종료

        StringBuilder sb=new StringBuilder();
        sb.append(idx+1).append('\n');
        int curIdx=idx;
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(curIdx==dp[i]){
                curIdx--;
                s.add(arr[i]);
            }
        }
        
        while(!s.empty()){
            int cur=s.pop();
            sb.append(cur).append(' ');
        }
                
        System.out.println(sb.toString());
        
        
    }
}