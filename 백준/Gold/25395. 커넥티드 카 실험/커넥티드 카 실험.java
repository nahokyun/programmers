import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class Car{
        int pos;
        int energy;
        int num;
        Car(int pos, int energy, int num){
            this.pos=pos;
            this.energy=energy;
            this.num=num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());
        Car[] arr=new Car[n];
        boolean[] visited=new boolean[n];
        
        for(int i=0;i<n;i++){
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st2.nextToken());
            arr[i]=new Car(a,b,i);
        }
        
        
        Queue<Car> q=new ArrayDeque<>();
        q.add(arr[s-1]);
        List<Integer> li=new ArrayList<>();
        int minPos=2000000000;
        int maxPos=-1;

        while(!q.isEmpty()){
            Car cur= q.poll();
            
            minPos=Math.min(minPos,cur.pos-cur.energy);
            maxPos=Math.max(maxPos,cur.pos+cur.energy);
            int cNum=cur.num;
            visited[cNum]=true;
            li.add(cNum);
            
            for(int i=cNum;i>=0;i--){
                if(arr[i].pos<cur.pos-cur.energy)
                    break;
                if(!visited[arr[i].num]){
                    q.add(arr[i]);
                    visited[arr[i].num]=true;
                }
            }
            
            for(int i=cNum;i<n;i++){
                if(arr[i].pos>cur.pos+cur.energy)
                    break;
                if(!visited[arr[i].num]){
                    q.add(arr[i]);
                    visited[arr[i].num]=true;
                }
            }

        }//큐 탐색 종료
        
        StringBuilder sb=new StringBuilder();
        Collections.sort(li);
        for(int i:li){
            sb.append(i+1+" ");
        }
        
        System.out.println(sb);
    }
}