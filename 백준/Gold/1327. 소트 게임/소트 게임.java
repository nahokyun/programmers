import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] result=new int[n];
        Set<String> set=new HashSet<>();
        Queue<int[]> q=new ArrayDeque<>();
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }//end of input
        result=arr.clone();
        Arrays.sort(result);
        
        q.add(arr.clone());
        int count=0;
        boolean flag=false;//정답이 있는지
        
        if(Arrays.equals(result,arr)){
            System.out.println(0);
            return;
        }
        
        while(!q.isEmpty()){
            Queue<int[]> tmp=new ArrayDeque<>();
            while(!q.isEmpty()){
                int[] cur=q.poll();
                
                for(int i=0;i<=n-k;i++){
                    int[] cmp=cur.clone();
                    for(int j=0;j<k;j++){
                        cmp[i+j]=cur[i+k-1-j];
                    }
                    if(!set.contains(Arrays.toString(cmp))){//들어온적 없는 배열일 때
                        tmp.add(cmp);
                        set.add(Arrays.toString(cmp));
                        if(Arrays.equals(cmp,result)){
                            flag=true;
                            break;
                        }
                    }
                }//idx 0부터 n-k까지 k개 변환 
                if(flag)
                    break;
            }//이번회차 탐색 종료
            
            count++;
            q=tmp;
            if(flag)
                break;
        }
        
        System.out.println(flag?count:-1);
    }
}