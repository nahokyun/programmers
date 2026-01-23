import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[4];
        int[] cmp=new int[4];
        int s= Integer.parseInt(st.nextToken());
        int p= Integer.parseInt(st.nextToken());
        int count=0;
        String input=br.readLine();
        
        for(int i=0;i<p;i++){
            if(input.charAt(i)=='A'){
                cmp[0]++;
            }else if(input.charAt(i)=='C'){
                cmp[1]++;
            }else if(input.charAt(i)=='G'){
                cmp[2]++;
            }else{
                cmp[3]++;
            }
        }
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        if(check(arr,cmp,p))
            count++;
        
        for(int i=p;i<s;i++){
            if(input.charAt(i)=='A'){
                cmp[0]++;
            }else if(input.charAt(i)=='C'){
                cmp[1]++;
            }else if(input.charAt(i)=='G'){
                cmp[2]++;
            }else{
                cmp[3]++;
            }
            
            if(input.charAt(i-p)=='A'){
                cmp[0]--;
            }else if(input.charAt(i-p)=='C'){
                cmp[1]--;
            }else if(input.charAt(i-p)=='G'){
                cmp[2]--;
            }else{
                cmp[3]--;
            }

            if(check(arr,cmp,p))
                count++;
        }
        
        
        System.out.println(count);
        
    }
    static public boolean check(int[] arr, int[] cmp, int p){
        for(int i=0;i<4;i++){
            if(arr[i]>cmp[i]){
                return false;
            }
        }
        return true;
    }
}