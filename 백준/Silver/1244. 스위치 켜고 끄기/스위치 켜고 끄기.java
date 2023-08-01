import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int student=Integer.parseInt(br.readLine());

        for(int i=0;i<student;i++){
            st=new StringTokenizer(br.readLine());
            int gender=Integer.parseInt(st.nextToken());
            int position=Integer.parseInt(st.nextToken());

            if(gender==1){//남학생일 경우
                for(int j=1;j*position-1<n;j++){
                    arr[position*j-1]=arr[position*j-1]==1?0:1;
                }
            }else{
                arr[position-1]=arr[position-1]==1?0:1;
                int j=1;
                while(true){
                    if(position-1+j<n&&position-1-j>=0) {
                        if(arr[position - 1 + j] == arr[position - 1 - j]){
                            arr[position - 1 + j]=arr[position-1+j]==1?0:1;
                            arr[position - 1 - j]=arr[position-1-j]==1?0:1;
                            j++;
                        }
                        else break;
                    }
                    else break;
                }
            }//학생별 스위치 처리 종료


        }//학생 입력 종료
        int count=0;
        for(int i=0;i<arr.length;i++) {
            System.out.printf(arr[i]+" ");
            count++;
            if(count==20) {
                System.out.println();
                count=0;
            }
        }


    }
}
