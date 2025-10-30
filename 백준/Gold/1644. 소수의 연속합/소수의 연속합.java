import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        
        boolean[] noDecimal=new boolean[n+1];
        
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(!noDecimal[i]){
                li.add(i);
                for(int j=i;j<=n;j=j+i){
                    noDecimal[j]=true;
                }
            }
        }//소수 판별 끝
        
        int left=0;
        int right=1;
        int count=0;
        int curVal=5;
        if(n<5){//투포인터 사용하기 전까지는 그냥 입력
            if(n==1){
                System.out.println(0);
            }
            if(n==2){
                System.out.println(1);
            }
            if(n==3){
                System.out.println(1);
            }
            if(n==4){
                System.out.println(0);
            }
            return;
        }else{
            while(left<=right&&right<li.size()){
                if(curVal<n){
                    if(right+1<li.size()){
                        right++;
                        curVal+=li.get(right);   
                    }else{
                        break;
                    }
                }else if(curVal>n){
                    curVal-=li.get(left);
                    left++;
                }else{
                    count++;
                    curVal-=li.get(left);
                    left++;
                }
            }
        }//판별 종료
        System.out.println(count);
    
    }
}