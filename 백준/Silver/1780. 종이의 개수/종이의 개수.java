
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main{

    private static int[][] arr;
    private static int n;
    private static int[] paper=new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i< n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j = 0; j< n; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        divAndCon(0,0,n);


        for(int i=0;i<3;i++){
            System.out.println(paper[i]);
        }
    }

    private static void divAndCon(int startX,int startY, int size) {

        int cur=arr[startY][startX];
        if(size==1) {
            paper[cur+1]++;
            return;
        }
        int ySize=startY+size;
        int xSize=startX+size;
        boolean flag=false;

        for(int i=startY;i<ySize;i++){
            for(int j=startX;j<xSize;j++){
                if(arr[i][j]!=cur){
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        if(flag){
            divAndCon(startX, startY, size/3);
            divAndCon(startX+size/3, startY, size/3);
            divAndCon(startX+size*2/3, startY, size/3);
            divAndCon(startX, startY+size/3, size/3);
            divAndCon(startX+size*2/3, startY+size/3, size/3);
            divAndCon(startX+size/3, startY+size/3, size/3);
            divAndCon(startX, startY+size*2/3, size/3);
            divAndCon(startX+size/3, startY+size*2/3, size/3);
            divAndCon(startX+size*2/3, startY+size*2/3, size/3);
        }else{
            paper[cur+1]++;
        }


    }
}
