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
        int count=0;
        int min=100000000;
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            
            if(s.empty()){
                if(y==0)
                    continue;
                min=y;
                s.push(y);
                count++;
            }else{
                if(min<=y){//현재값이 최소값보다 크거나 같을때
                    if(min==0){
                        s=new Stack<>();
                        s.push(y);
                        min=y;
                        count++;
                        continue;
                    }
                    
                    while(s.peek()>y){
                        s.pop();
                    }
                    if(s.peek()==y)
                        continue;
                    if(s.peek()<y)
                        count++;
                    s.push(y);
                    //System.out.println(x+"일때 "+y+"넣음");
                }else{//현재값이 최소값보다 작을때 
                    s=new Stack<>();
                    s.push(y);
                    min=y;
                    if(y!=0){
                        count++;
                        //System.out.println(x+"일때 "+y+"넣음1");
                    }
                }
            }
            //System.out.println("현재 "+x+"일때 "+min+"이 최소값");
        }
        System.out.println(count);
        
    }
}
