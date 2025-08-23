import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static long tree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb=new StringBuilder();
        while((s=br.readLine())!=null){
            StringTokenizer st=new StringTokenizer(s);
            int n=Integer.parseInt(st.nextToken());
            int queryN=Integer.parseInt(st.nextToken());

            int h=(int)Math.ceil((Math.log(n)/Math.log(2)));
            int size=(int)Math.pow(2,h+1);
            tree=new long[size];
            Arrays.fill(tree,1);
            int[] arr=new int[n+1];
            st=new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                int tmp=Integer.parseInt(st.nextToken());
                
                if(tmp>0){
                    arr[i]=1;
                }else if(tmp<0){
                    arr[i]=-1;
                }else arr[i]=0;
                
                //arr[i]=tmp;
            }
            
            init(arr,1,n,1);
            
            for(int i=1;i<=queryN;i++){
                st=new StringTokenizer(br.readLine());
                char command=st.nextToken().charAt(0);
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                //System.out.println(Arrays.toString(tree));
                if(command=='C'){//C - 변경
                    
                    if(b<0){
                        b=-1;
                    }else if(b>0){
                        b=1;
                    }else b=0;
                    
                    update(arr,1,n,1,a,b);
                }else{//P - 곱셈
                    long result=findMul(1,n,1,a,b);
                    if(result>0){
                        sb.append('+');
                    }else if(result<0){
                        sb.append('-');
                    }else sb.append(0);
                   
                }
                
            }
            sb.append('\n');
            
        }//테케 종료 
        System.out.println(sb);
    }//main종료
    static public long init(int[] arr, int start, int end, int node){
        if(start==end){
            return tree[node]=arr[start];
        }
        return tree[node]=init(arr,start,(start+end)/2,node*2)*init(arr,(start+end)/2+1,end,node*2+1);
    }
    
    static public long update(int[] arr, int start, int end, int node, int idx, int value){
        
        if(start>idx||idx>end)
            return tree[node];

        if(start==end){
            return tree[node]=value;
        }
        return tree[node]=update(arr,start,(start+end)/2,node*2,idx,value)*update(arr,(start+end)/2+1,end,node*2+1,idx,value);
        
        
    }
    
    static public long findMul(int start, int end, int node, int left, int right){
        if(right<start||end<left){
            return 1;
        }
        if(left<=start&&end<=right){
            return tree[node];
        }
        return findMul(start,(start+end)/2,node*2,left,right)*findMul((start+end)/2+1,end,node*2+1,left,right);
    }
    
    
}