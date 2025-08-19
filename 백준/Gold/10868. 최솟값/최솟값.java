import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int tree[];
    static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
        int queryN=Integer.parseInt(st.nextToken());
        
        int h=(int)Math.ceil(Math.log(n)/Math.log(2));
        int size=(int)Math.pow(2,h+1);
        tree=new int[size];
        
        int[] arr=new int[n+1];
        
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        init(arr,1,1,n);
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<queryN;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            result=1000000000;
            findMin(1,n,1,a,b);
            
            sb.append(result).append('\n');
        }
        
        System.out.println(sb);
        
        
        
        
    }
    static public void init(int[] arr,int node, int start, int end){
        if(start==end){
            tree[node]=arr[start];
        }else{
            init(arr,node*2,start,(start+end)/2);
            init(arr,node*2+1,(start+end)/2+1,end);
            
            if(tree[node*2]<tree[node*2+1]){
                tree[node]=tree[node*2];
            }else{
                tree[node]=tree[node*2+1];
            }
        }
    }
    static public void findMin(int start, int end,int node, int left,int right){
        if(end<left||right<start)
            return;
        if(left<=start&&end<=right){
            result=Math.min(result,tree[node]);
            return;
        }
        findMin(start,(start+end)/2,node*2,left,right);
        findMin((start+end)/2+1,end,node*2+1,left,right);
    }
}