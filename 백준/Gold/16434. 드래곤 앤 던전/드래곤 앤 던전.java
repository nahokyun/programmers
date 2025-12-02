import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class Room{
        int t;
        long a;
        long h;
        Room(int t,long a,long h){
            this.t=t;
            this.a=a;
            this.h=h;
        }
    }
    
    static Room[] rooms;
    static long curAtk;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        long hAtk=Integer.parseInt(st.nextToken());
        rooms=new Room[n];
        long right=0;
        curAtk=hAtk;
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int t=Integer.parseInt(st.nextToken());
            long a=Integer.parseInt(st.nextToken());
            long h=Integer.parseInt(st.nextToken());
            
            rooms[i]=new Room(t,a,h);
            if(t==1){
                right+=(h/curAtk+1)*a;//Long.maxvalue에서 대충 줄인값
            }
        }
        
        long left=0;
        while(left+1<right){
            curAtk=hAtk;
            long mid=(left+right)/2;
            if(check(mid)){
                right=mid;
            }else{
                left=mid;
            }
        }
        System.out.println(right);
 
    }
    public static boolean check(long mid){
        long curHp=mid;
        for(int i=0;i<n;i++){
            if(rooms[i].t==1){//몬스터가 있을경우
                if((curHp=fight(curHp,rooms[i].a,rooms[i].h))<=0){//싸움에서 질 경우
                    return false;
                }
            }else{//포션 있을경우
                curAtk+=rooms[i].a;
                curHp=Math.min(curHp+rooms[i].h,mid);
            }
        }
        return true;
    }
    
    public static long fight(long curHp,long a, long h){
        long i=h/curAtk;
        long j=h%curAtk;
        
        if(j==0){
            i--;
        }
        curHp-=i*a;
        return curHp;
    }
    
    
}