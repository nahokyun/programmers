import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class Ability implements Comparable<Ability>{
        int group;
        int stat;
        Ability(int group, int stat){
            this.group=group;
            this.stat=stat;
        }
        @Override
        public int compareTo(Ability o){
            return this.stat-o.stat;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        List<PriorityQueue<Ability>> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            li.add(new PriorityQueue<Ability>());
        }
        
        
        
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                li.get(i).add(new Ability(i,Integer.parseInt(st.nextToken())));
            }
        }//입력 종료
        
        Ability[] students=new Ability[n];
        for(int i=0;i<n;i++){
            students[i]=li.get(i).poll();
        }
        
        Arrays.sort(students);
        int min=students[n-1].stat-students[0].stat;
        //System.out.println(students[0].group+" "+students[0].stat+" "+students[n-1].group+" "+students[n-1].stat);
        while(true){
            if(!li.get(students[0].group).isEmpty()){
                students[0]=li.get(students[0].group).poll();
                Arrays.sort(students);
                min=Math.min(min,students[n-1].stat-students[0].stat);
            }else
                break;
        }
        
        
        
        System.out.println(min);
        
        
        
    }
}