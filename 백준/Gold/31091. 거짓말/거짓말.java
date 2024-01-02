
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] down=new int[n+1];
        int[] up=new int[n+1];
        int[] downSum=new int[n+1];
        int[] upSum=new int[n+1];
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            int tmp= Integer.parseInt(st.nextToken());
            if(tmp<=0){
                down[-tmp]+=1;
            }else{
                up[tmp]+=1;
            }
        }
        //입력 종료

        downSum[n]=down[n];
        upSum[0]=up[0];
        for(int i=1;i<=n;i++){
            upSum[i]=upSum[i-1]+up[i];
        }

        for(int i=n-1;i>=0;i--){
            downSum[i]=downSum[i+1]+down[i];
        }

        StringBuilder sb=new StringBuilder();
        List<Integer> li=new ArrayList<>();


        for(int i=0;i<=n;i++){
            if(upSum[i]+downSum[i]+i==n) {
                li.add(i);
            }
        }
        sb.append(li.size()).append('\n');
        for(int i=0;i<li.size();i++){
            sb.append(li.get(i)).append(' ');
        }

        System.out.println(sb);

        
    }
}
