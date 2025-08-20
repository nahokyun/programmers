import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static long tree[];
    static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
        int queryN=Integer.parseInt(st.nextToken());
        
        int h=(int)Math.ceil(Math.log(n)/Math.log(2));
        int size=(int)Math.pow(2,h+1);
        tree=new long[size];
        long[] arr=new long[n+1];
        st=new StringTokenizer(br.readLine());
        
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }//초기배열 입력완료
        
        
        init(arr,1,1,n);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<queryN;i++){
            
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            result=findSum(1,n,1,(int)Math.min(x,y),(int)Math.max(x,y));
            sb.append(result).append('\n');
            //System.out.println(Arrays.toString(tree));
            update(1,1,n,a,b-arr[a]);
            arr[a]=b;
            //System.out.println(Arrays.toString(tree));
  
        }
        
        
        System.out.println(sb);
    }
    static public long init(long[] arr, int node, int start, int end){
        if(start==end){
            return tree[node]=arr[start];
        }
        return tree[node]=init(arr,node*2,start,(start+end)/2)+init(arr,node*2+1,(start+end)/2+1,end);
           
        
    }
    
    static public void update(int node, int start, int end, int idx, long diff){
        if(start<=idx&&idx<=end){
            tree[node]+=diff;
        }else{
            return;
        }
        
        if(start==end)return;
        
        update(node*2,start,(start+end)/2,idx,diff);
        update(node*2+1,(start+end)/2+1,end,idx,diff);
    }
    
    static public long findSum(int start, int end, int node, int left, int right){
        if(end<left||right<start)
            return 0;
        if(left<=start&&end<=right){
            return tree[node];
        }
        
        return findSum(start,(start+end)/2,node*2,left,right)+findSum((start+end)/2+1,end,node*2+1,left,right);
    }


}