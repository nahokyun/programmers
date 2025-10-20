import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Stack<Integer> s=new Stack<>();
        int[] arr=new int[n+1];
        int[] count=new int[n+1];
        int[] nearest=new int[n+1];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            nearest[i]=1000000;
        }
        
        
        for(int i=1;i<=n;i++){
            while(!s.empty()&&arr[s.peek()]<=arr[i]){
                s.pop();
            }
            count[i]=s.size();
            if(s.size()>0){
                nearest[i]=s.peek();
            }
            s.push(i);
        }
        
        s=new Stack<>();
        for(int i=n;i>=1;i--){
            while(!s.empty()&&arr[s.peek()]<=arr[i]){
                s.pop();
            }
            count[i]+=s.size();
            if(s.size()>0){
                nearest[i]=Math.abs(s.peek()-i)<Math.abs(i-nearest[i])?s.peek():nearest[i];
            }
            s.push(i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            if(count[i]!=0)
                sb.append(count[i]).append(' ').append(nearest[i]).append('\n');
            else
                sb.append(0).append('\n');
        }
        
        System.out.println(sb);
        
    }
}
