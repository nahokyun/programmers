import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static List<List<Node>> li;
    static boolean flag=false;
    static boolean[] check;
    
    static class Node {
        int next;
        int weight;
        public Node(int x,int w){
            this.next=x;
            this.weight=w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int left=1;
        int right=1_000_000_001;
        li=new ArrayList<>();
        for(int i=0;i<=n;i++){
            li.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            li.get(a).add(new Node(b,c));
            li.get(b).add(new Node(a,c));
        }
        st=new StringTokenizer(br.readLine());
        int f1=Integer.parseInt(st.nextToken());
        int f2=Integer.parseInt(st.nextToken());
        //입력 종료
        

        while(left+1<right){
            flag=false;
            check=new boolean[n+1];
            int mid=(left+right)/2;
            valid(mid,f1,f2);
            if(flag){
                left=mid;
            }else{
                right=mid;
            }
        }
        System.out.println(left);
    }//end of main
    
    static public void valid(int mid, int f1, int f2){
        if(f1==f2){
            flag=true;
            return ;
        }
        check[f1]=true;
        for(Node cur:li.get(f1)){
            if(!check[cur.next]&&mid<=cur.weight){
                valid(mid,cur.next,f2);
            }
            if(flag)
                return;
        }
    }
}