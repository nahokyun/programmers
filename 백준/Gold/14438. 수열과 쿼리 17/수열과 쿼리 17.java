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
            //System.out.println(Arrays.toString(tree));
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
            return tree[node]=arr[start];
        }
        return tree[node]=Math.min(init(arr,start,(start+end)/2,node*2),init(arr,(start+end)/2+1,end,node*2+1));
    }
    static public int update(int[] arr, int start, int end, int node, int idx, int value){
        if(end<idx||idx<start){//범위 바깥일때
            return tree[node];
        }
        if(start==end)
            return tree[node]=value;
        return tree[node]=Math.min(update(arr,start,(start+end)/2,node*2,idx,value),update(arr,(start+end)/2+1,end,node*2+1,idx,value));
    }
    
    static public int findMin(int start, int end, int node, int left, int right){

        if(end<left||right<start){
            return 1000000000;
        }
        if(left<=start&&end<=right){
            return tree[node];
        }
        return Math.min(findMin(start,(start+end)/2,node*2,left,right),findMin((start+end)/2+1,end,node*2+1,left,right));
        
    }

    
}