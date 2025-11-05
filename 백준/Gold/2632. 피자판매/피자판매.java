import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int goal=Integer.parseInt(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        int m=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int[] arr1=new int[2*m+1];
        int[] arr2=new int[2*n+1];
        
        for(int i=1;i<=m;i++){
            arr1[i]=Integer.parseInt(br.readLine());
            arr1[i+m]=arr1[i];
        }//a피자 입력
        
        for(int i=1;i<=n;i++){
            arr2[i]=Integer.parseInt(br.readLine());
            arr2[i+n]=arr2[i];
        }//b피자 입력
        
        int[] sum1=new int[m*2+1];
        int[] sum2=new int[n*2+1];
        
        for(int i=1;i<=2*m;i++){
            sum1[i]=sum1[i-1]+arr1[i];
        }
        for(int i=1;i<=2*n;i++){
            sum2[i]=sum2[i-1]+arr2[i];
        }
        
        int[] methodCount1=new int[goal+1];
        int[] methodCount2=new int[goal+1];
        
        for(int i=1;i<m;i++){//조각 선택수
            for(int j=1;j<=m;j++){//몇번째부터 고를지
                int tmp=sum1[j+i-1]-sum1[j-1];
                if(tmp>goal)
                    continue;
                methodCount1[tmp]++;
            }
        }
        if(sum1[m]<=goal)
            methodCount1[sum1[m]]++;
        
        for(int i=1;i<n;i++){//조각 선택수
            for(int j=1;j<=n;j++){//몇번째부터 고를지
                int tmp=sum2[j+i-1]-sum2[j-1];
                if(tmp>goal)
                    continue;
                methodCount2[tmp]++;
            }
        }
        if(sum2[n]<=goal)
            methodCount2[sum2[n]]++;
        
        int result=0;
        result+=methodCount1[goal];
        result+=methodCount2[goal];
        for(int i=1;i<goal;i++){
            result+=methodCount1[i]*methodCount2[goal-i];
        }
        
        System.out.println(result);
    }
}