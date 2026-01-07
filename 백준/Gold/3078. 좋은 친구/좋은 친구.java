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
        int[] sizes=new int[21];
        String[] names=new String[n];
        long count=0;
        
        for(int i=0;i<n;i++){
            names[i]=br.readLine();
        }
        
        for(int i=0;i<k;i++){
            if(sizes[names[i].length()]!=0){
                count+=sizes[names[i].length()];
            }
            sizes[names[i].length()]++;
        }
        
        for(int i=k;i<n;i++){
            count+=sizes[names[i].length()];
            sizes[names[i-k].length()]--;
            sizes[names[i].length()]++;
        }
        
        
        System.out.println(count);
    }
}