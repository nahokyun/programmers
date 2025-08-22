import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static long tree[];
    static long tree2[];
    static long result;
    static long min;
    static long max;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
        int queryN=Integer.parseInt(st.nextToken());
        
        int h=(int)Math.ceil((Math.log(n)/Math.log(2)));
        int size=(int)Math.pow(2,h+1);
        tree=new long[size];
        tree2=new long[size];
        int[] arr=new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        init(arr,1,n,1);
        init2(arr,1,n,1);
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<queryN;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            //System.out.println(Arrays.toString(tree));
            sb.append(findMin(1,n,a,b,1)).append(' ').append(findMax(1,n,a,b,1)).append('\n');
        }
        System.out.println(sb);
    }
    static public long init(int[] arr, int start, int end, int node){
        if(start==end){
            return tree[node]=arr[start];
        }
        return tree[node]=(long)Math.min(init(arr,start,(start+end)/2,node*2),init(arr,(start+end)/2+1,end,node*2+1));   
    }
    
    static public long init2(int[] arr, int start, int end, int node){
        if(start==end){
            return tree2[node]=arr[start];
        }
        return tree2[node]=(long)Math.max(init2(arr,start,(start+end)/2,node*2),init2(arr,(start+end)/2+1,end,node*2+1));   
    }
    
    static public long findMin(int start, int end, int left, int right,int node){
        if(start>right||end<left){
            return 2000000000;
        }
        if(left<=start&&end<=right){
            return tree[node];
        }
        return (long)Math.min(findMin(start,(start+end)/2,left,right,node*2),findMin((start+end)/2+1,end,left,right,node*2+1));
    }
    
    static public long findMax(int start, int end, int left, int right,int node){
        if(start>right||end<left){
            return 0;
        }
        if(left<=start&&end<=right){
            return tree2[node];
        }
        return (long)Math.max(findMax(start,(start+end)/2,left,right,node*2),findMax((start+end)/2+1,end,left,right,node*2+1));
    }

}