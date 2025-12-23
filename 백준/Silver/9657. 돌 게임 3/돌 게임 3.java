import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        //1 sk 1
        //2 cy 1 /1
        //3 sk 3
        //4 sk 4
        //5 sk 3 /1 1
        //6 sk 4 /1 1
        //7 cy 1 /4 1 1
        //7로 나눴을때 나머지에 따라 반복됨
        System.out.println(n%7==0||n%7==2?"CY":"SK");
    }
}