import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String cur;
        int count=0;
        StringBuilder sb=new StringBuilder();
        Map<String,Integer> map=new HashMap<>();
        
        while((cur=br.readLine())!=null){
            count++;
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        List<String> key=new ArrayList<>(map.keySet());
        Collections.sort(key);
        
        for(String cur2: key){
            sb.append(cur2).append(' ').append(String.format("%.4f",(double)map.get(cur2)/count*100)).append('\n');
        }
        
        
        
        
        System.out.println(sb);
    }
}