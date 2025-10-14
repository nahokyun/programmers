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
        }//입력종료
        
        int[] longest=new int[n];
        longest[0]=arr[0];
        int idx=0;
        int count=0;
        for(int i=1;i<n;i++){
            if(longest[idx]<arr[i]){
                count++;
                longest[++idx]=arr[i];
            }else{
                int left=-1;
                int right=idx;
                while(left+1<right){
                    int mid=(left+right)/2;
                    if(longest[mid]<arr[i]){
                        left=mid;
                    }else{
                        right=mid;
                    }
                }
                longest[right]=arr[i];
            }
        }
        
        System.out.println(count+1);
        
        
    }
}