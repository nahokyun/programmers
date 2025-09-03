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
            arr[i]=Integer.parseInt(st.nextToken())%2;
        }
        
        init(arr,1,n,1);
        //System.out.println(Arrays.toString(arr));
        int queryN=Integer.parseInt(br.readLine());
        //System.out.println(Arrays.toString(tree));
        for(int i=0;i<queryN;i++){
            st=new StringTokenizer(br.readLine());
            int com=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            //System.out.println(Arrays.toString(tree));
            if(com==1){//update
                if(arr[a]==b%2)
                    continue;
                if(b%2==1)//짝수->홀수  0->1
                    update(arr,1,n,1,a,1);
                else//홀수->짝수   1->0
                    update(arr,1,n,1,a,-1);
                arr[a]=b%2;
            }else if(com==2){//짝수
                sb.append(b-a+1-findOdd(1,n,1,a,b)).append('\n');
            }else{//홀수
                sb.append(findOdd(1,n,1,a,b)).append('\n');
            }
        }
        System.out.println(sb);
    }//main종료
    
    static public int init(int[] arr, int start, int end, int node){
        if(start==end){
            return tree[node]=arr[start];
        }
        int mid=(start+end)/2;
        return tree[node]=init(arr,start,mid,node*2)+init(arr,mid+1,end,node*2+1);
    }
    
    static public void update(int[] arr, int start, int end, int node, int idx,int value){
        if(start<=idx&&idx<=end){
            tree[node]+=value;
        }else 
            return;
        
        if(start==end){
            //tree[node]=value;
            return;
        }
        int mid=(start+end)/2;
        update(arr,start,mid,node*2,idx,value);
        update(arr,mid+1,end,node*2+1,idx,value);
    }
    
    static public int findOdd(int start,int end, int node, int left, int right){
        if(end<left||start>right){
            return 0;
        }
        if(left<=start&&end<=right){
            return tree[node];
        }
        int mid=(start+end)/2;
        return findOdd(start,mid,node*2,left,right)+findOdd(mid+1,end,node*2+1,left,right);
    }


    
}