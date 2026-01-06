import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class Student implements Comparable<Student>{
        int age;
        int recom;
        int num;
        
        public Student(int a, int r, int n){
            age=a;
            recom=r;
            num=n;
        }
        @Override
        public int compareTo(Student o){
            if(this.recom==o.recom){
                return this.age-o.age;
            }
            return this.recom-o.recom;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        List<Student> li=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();//num, recom정보
        
        for(int i=0;i<m;i++){
            int cur=Integer.parseInt(st.nextToken());
            if(li.size()<n){
                if(map.get(cur)==null){//처음 들어가는 학생일경우
                    li.add(new Student(i+1,1,cur));
                    map.put(cur,1);
                }else{//이미 들어가있을경우
                    int idx=-1;
                    for(int j=0;j<li.size();j++){
                        if(li.get(j).num==cur){
                            idx=j;
                            break;
                        }
                    }
                    li.set(idx,new Student(li.get(idx).age,li.get(idx).recom+1,li.get(idx).num));
                    map.replace(cur,map.get(cur)+1);
                }
            }else{//사진틀 꽉 차있을때
                if(map.get(cur)!=null){//이미 들어가있을경우
                    int idx=-1;
                    for(int j=0;j<li.size();j++){
                        if(li.get(j).num==cur){
                            idx=j;
                            break;
                        }
                    }
                    li.set(idx,new Student(li.get(idx).age,li.get(idx).recom+1,li.get(idx).num));
                    map.replace(cur,map.get(cur)+1);
                }else{//처음일경우
                    map.remove(li.get(0).num);
                    map.put(cur,1);
                    
                    li.remove(0);
                    li.add(new Student(i+1,1,cur));
                }
            }//end of 사진틀 꽉 차있을때
            Collections.sort(li);
        }//입력종료
        
        //출력
        int[] arr=new int[n];
        for(int i=0;i<li.size();i++){
            arr[i]=li.get(i).num;
        }
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(arr[i]!=0)
                sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
        
    }
}