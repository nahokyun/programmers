
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.awt.Point;

public class Main {

    private static Point[] h;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        h = new Point[m];
        for(int i=0;i<m;i++) {
            int tmp=Integer.parseInt(st.nextToken());
            h[i]=new Point(tmp,tmp);
        }

        //point.x는 최대값, point.y는 빗물이 가능한 높이

        int left=h[0].y;
        for(int i=1;i<m;i++){
            if(h[i].y>left) {
                left = h[i].y;

            }
            h[i].x = left;
        }
        int right=h[m-1].y;
        for(int i=m-1;i>=0;i--){
            if(h[i].y>right){
                right=h[i].y;
            }
            h[i].x=Math.min(right,h[i].x);
        }



        int count=0;
        for(int i=0;i<m;i++) {
            if(h[i].x>=h[i].y)
                count+=h[i].x-h[i].y;
        }

        System.out.println(count);


    }


}

