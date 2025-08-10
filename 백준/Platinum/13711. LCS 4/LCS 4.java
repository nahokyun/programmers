import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] arr1=new int[n];
        int[] arr2=new int[n];
        int[] idxArr=new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine());
		HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
			arr1[i]=Integer.parseInt(st.nextToken());
            map.put(arr1[i],i);
		}
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
			arr2[i]=Integer.parseInt(st.nextToken());
            idxArr[i]=map.get(arr2[i]);
		}//입력 종료
        //System.out.println(Arrays.toString(idxArr));
        
        
        int[] longestArr=new int[n];
        longestArr[0]=idxArr[0];
        int idx=0;
        for(int i=1;i<n;i++){
            int cur=idxArr[i];
            if(longestArr[idx]<cur){
                longestArr[++idx]=cur;
            }else{
                int left=-1;
                int right=idx;
                while(left+1<right){
                    int mid=(left+right)>>1;
                    if(longestArr[mid]<cur){
                        left=mid;
                    }else{
                        right=mid;
                    }
                }
                longestArr[right]=cur;
            }
        }
        
        System.out.println(idx+1);
        
    }
}