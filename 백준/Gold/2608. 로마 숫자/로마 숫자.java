import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String in1=br.readLine();
        String in2=br.readLine();
        int sum=0;
        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        
        sum=convert(in1,0,0)+convert(in2,0,0);
        sb.append(sum).append('\n');
        sb.append(convert2(new StringBuilder(),sum));
        System.out.println(sb);
    }//end of main
    
    public static int convert(String in, int sum, int idx){
        if(idx>=in.length())
            return sum;
        
        if(in.charAt(idx)=='I'){
            if(idx+1<in.length()){
                if(in.charAt(idx+1)=='V'){//IV일때
                    return convert(in,sum+4,idx+2);
                }else if(in.charAt(idx+1)=='X'){//IX일때
                    return convert(in,sum+9,idx+2);
                }
            }
            return convert(in,sum+1,idx+1);//I
        }else if(in.charAt(idx)=='X'){
            if(idx+1<in.length()){
                if(in.charAt(idx+1)=='L'){//XL일때
                    return convert(in,sum+40,idx+2);
                }else if(in.charAt(idx+1)=='C'){//XC일때
                    return convert(in,sum+90,idx+2);
                }
            }
            return convert(in,sum+10,idx+1);//I
        }else if(in.charAt(idx)=='C'){
            if(idx+1<in.length()){
                if(in.charAt(idx+1)=='D'){//CD일때
                    return convert(in,sum+400,idx+2);
                }else if(in.charAt(idx+1)=='M'){//CM일때
                    return convert(in,sum+900,idx+2);
                }
            }
            return convert(in,sum+100,idx+1);//C
        }else if(in.charAt(idx)=='V'){
            return convert(in,sum+5,idx+1);
        }else if(in.charAt(idx)=='L'){
            return convert(in,sum+50,idx+1);
        }else if(in.charAt(idx)=='D'){
            return convert(in,sum+500,idx+1);
        }else if(in.charAt(idx)=='M'){
            return convert(in,sum+1000,idx+1);
        }
        return 0;
    }
    public static StringBuilder convert2(StringBuilder sb,int sum){
        if(sum>=1000){
            for(int i=0;i<sum/1000;i++){
                sb.append('M');
            }
            return convert2(sb,sum%1000);
        }
        if(sum>=900){
            sb.append("CM");
            return convert2(sb,sum%900);
        }
        if(sum>=500){
            sb.append('D');
            return convert2(sb,sum%500);
        }
        if(sum>=400){
            sb.append("CD");
            return convert2(sb,sum%400);
        }
        if(sum>=100){
            for(int i=0;i<sum/100;i++){
                sb.append('C');
            }
            return convert2(sb,sum%100);
        }
        if(sum>=90){
            sb.append("XC");
            return convert2(sb,sum%90);
        }
        if(sum>=50){
            sb.append('L');
            return convert2(sb,sum%50);
        }
        if(sum>=40){
            sb.append("XL");
            return convert2(sb,sum%40);
        }
        if(sum>=10){
            for(int i=0;i<sum/10;i++){
                sb.append('X');
            }
            return convert2(sb,sum%10);
        }
        if(sum>=9){
            sb.append("IX");
            return convert2(sb,sum%9);
        }
        if(sum>=5){
            sb.append('V');
            return convert2(sb,sum%5);
        }
        if(sum>=4){
            sb.append("IV");
            return convert2(sb,sum%4);
        }
        if(sum>=1){
            for(int i=0;i<sum;i++){
                sb.append('I');
            }
            return sb;
        }
        
        return sb;
    }
    
}