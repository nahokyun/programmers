import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        int min=2_000_000_002;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int snowman=arr[i]+arr[j];
                
                int left=i+1;
                int right=n-1;
                
                while(left<right){
                    if(left==j){
                        left++;
                        continue;
                    }
                    if(right==j||right==i){
                        right--;
                        continue;
                    }                  
                    
                    int snowman2=arr[left]+arr[right];
                    
                    min=Math.min(min,Math.abs(snowman-snowman2));
                    
                    if(snowman>snowman2){
                        left++;
                    }else if(snowman<snowman2){
                        right--;
                    }else{
                        System.out.println(0);
                        return;
                    }
                }
                
                
            }
        }
        System.out.println(min);
        
        
    }
}