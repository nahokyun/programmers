import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static public int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        String t= br.readLine();
        StringBuilder ssb=new StringBuilder();
        StringBuilder tsb=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            ssb.append(s.charAt(i));
        }
        
        for(int i=0;i<t.length();i++){
            tsb.append(t.charAt(i));
        }
        
        find(ssb, tsb);
        System.out.println(result);
    }
    
    static public void find(StringBuilder ssb, StringBuilder tsb){
        if(ssb.length()==tsb.length()){
            if(ssb.toString().equals(tsb.toString()))
                result=1;
            return;
        }
        
        if(tsb.charAt(tsb.length()-1)=='A'){
            tsb.deleteCharAt(tsb.length()-1);
            find(ssb,tsb);
        }else{
            tsb.deleteCharAt(tsb.length()-1);
            find(ssb,tsb.reverse());
        }
        
        
    }
}