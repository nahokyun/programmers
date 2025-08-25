import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int[] tree;
    static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        int h=(int)Math.ceil(Math.log(n)/Math.log(2));
        int size=(int)Math.pow(2,h+1);
        tree=new int[size+1];
        arr=new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        init(arr,1,n,1);
        int queryN=Integer.parseInt(br.readLine());
        for(int i=0;i<queryN;i++){
            st=new StringTokenizer(br.readLine());
            int com=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            
            if(com==1){//update
                update(arr,1,n,1,a,b);
            }else{//findMin
                sb.append(findMin(1,n,1,a,b)).append('\n');
            }
        }
        System.out.println(sb);
    }//main종료
    static public int init(int[] arr, int start, int end, int node){
        if(start==end){
            return tree[node]=start;
        }
        return tree[node]=minIdx(init(arr,start,(start+end)/2,node*2),init(arr,(start+end)/2+1,end,node*2+1));
    }
    
    static public int minIdx(int a, int b){
        if(a==1000000){
            return b;
        }
        if(b==1000000){
            return a;
        }
        if(arr[a]==arr[b]){
            return (int)Math.min(a,b);
        }else{
            return arr[a]>arr[b]?b:a;
        }
    }

    static public int update(int[] arr, int start, int end, int node, int idx, int value){
        if(idx<start||idx>end){
            return tree[node];
        }
        
        if(start==end){
            arr[idx]=value;
            return tree[node]=idx;
        }
        
        return tree[node]=minIdx(update(arr,start,(start+end)/2,node*2,idx,value),update(arr,(start+end)/2+1,end,node*2+1,idx,value)); 
    }
    static public int findMin(int start,int end, int node, int left, int right){
        if(end<left||right<start)
            return 1000000;
        if(left<=start&&end<=right){
            return tree[node];
        }
        return minIdx(findMin(start,(start+end)/2,node*2,left,right),findMin((start+end)/2+1,end,node*2+1,left,right));
    }
    
}