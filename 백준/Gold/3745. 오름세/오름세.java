import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String input="";
        StringBuilder sb=new StringBuilder();
        while((input=br.readLine())!=null){
            int n=Integer.parseInt(input.trim());
            int[] arr=new int[n];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }//입력 종료

            int[] longestArr=new int[n+1];
            longestArr[0]=arr[0];

            int idx=0;
            for(int i=1;i<n;i++){
                int cur=arr[i];

                if(cur>longestArr[idx]){
                    longestArr[++idx]=cur;
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
                }//이분탐색 종료
            }//for문 종료
            sb.append(idx+1).append('\n');
        }//입력종료
        System.out.println(sb.toString());
        
        
    }
}