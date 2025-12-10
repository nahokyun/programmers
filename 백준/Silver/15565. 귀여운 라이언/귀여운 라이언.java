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
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n+1];
        int[] sum=new int[n+1];
        int right=-1;
        int left=-1;
        boolean findR=false;
        boolean findL=false;
        for(int i=1;i<=n;i++){
            int cur=Integer.parseInt(st.nextToken());
            arr[i]=cur==2?0:cur;
            sum[i]=sum[i-1]+arr[i];
            if(!findR&&sum[i]==k){
                right=i;
                findR=true;
            }
            if(!findL&&sum[i]==1){
                left=i;
                findL=true;
            }
        }//입력종료
        
        boolean up=false;//left를 올릴지 right를 올릴지 정하는 flag
        int cnt=Integer.MAX_VALUE;
        //System.out.println(Arrays.toString(sum));
        //System.out.println(1+" "+right);
        if(right==-1){
            System.out.println(-1);
            return;
        }else{
            while(right<=n){
                //if(arr[left]==1&&arr[right]==1)
                cnt=Math.min(cnt,right-left+1);
                if(!up){//right를 올려야할때
                    while(right<n&&arr[right+1]==0)
                        right++;
                    right++;
                    up=true;
                }else{
                    while(left<right&&arr[left+1]==0)
                        left++;
                    left++;
                    up=false;
                }
            }
        }
        
        
        System.out.println(cnt);
        
    }
}