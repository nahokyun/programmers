import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public int compareTo(Point cur){
            return x-cur.x;
        }        
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        int[] longestArr=new int[n];
        Point[] pointArr=new Point[n];
        Point[] resultArr=new Point[n];//idx저장용
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine().trim());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            
            pointArr[i]=new Point(a,b);
        }
        Arrays.sort(pointArr);

        longestArr[0]=pointArr[0].y;
        resultArr[0]=new Point(0,pointArr[0].x);
        int idx=0;
        for(int i=1;i<n;i++){
            int cur=pointArr[i].y;
            if(longestArr[idx]<cur){
                longestArr[++idx]=cur;
                resultArr[i]=new Point(idx,pointArr[i].x);
                continue;
            }
            int left=-1;
            int right=idx;
            
            while(left+1<right){
                int mid=(left+right)/2;
                if(longestArr[mid]<cur){
                    left=mid;
                }else{
                    right=mid;
                }
            }
            longestArr[right]=cur;
            resultArr[i]=new Point(right,pointArr[i].x);
        }//탐색 끝
        
        int max=idx;
        StringBuilder sb=new StringBuilder();
        sb.append(n-1-max).append('\n');
        
        boolean[] need=new boolean[n];
        for(int i=n-1;i>=0;i--){
            if(resultArr[i].x==max){
                need[i]=true;
                max--;
            }
        }
        
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!need[i]){
                li.add(resultArr[i].y);
            }
        }
        Collections.sort(li);
        for(Integer i:li){
            sb.append(i).append('\n');
        }
        
        System.out.println(sb);
    }
}