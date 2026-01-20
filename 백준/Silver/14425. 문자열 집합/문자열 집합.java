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
        int m=Integer.parseInt(st.nextToken());
        int count=0;
        Set<String> set=new HashSet<>();
        
        for(int i=0;i<n;i++){
            set.add(br.readLine());
        }
        
        for(int i=0;i<m;i++){
            if(set.contains(br.readLine()))
                count++;
        }
        
        System.out.println(count);
        
    }
}