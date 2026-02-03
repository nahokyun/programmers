import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        char[] duck={'q','u','a','c','k'};
        char[] arr=st.toCharArray();
        int lastIdx=0;
        int count=0;
        boolean breakFlag=false;//반복 탈출 조건
        boolean correctFlag=false;
        
        while(true){
            boolean duckExist=false;//오리 한마리 존재여부 확인
            int idx=0;
            int[] tmp=new int[5];//quack 임시 인덱스 저장
            for(int i=0;i<st.length();i++){
                if(duck[idx]==arr[i]){
                    tmp[idx]=i;
                    idx++;
                    if(idx==5){
                        if(!duckExist){
                            count++;
                            duckExist=true;
                        }  
                        for(int j=0;j<5;j++){
                            arr[tmp[j]]='\0';
                        }
                        idx=0;
                    }
                }
            }//end of cycle
            
            for(int i=0;i<st.length();i++){
                if(arr[i]!='\0'){
                    if(lastIdx!=i){
                        lastIdx=i;
                    }else{//한바퀴 돌려도 안지워질때
                        breakFlag=true;
                    }
                    break;
                }
                if(i==st.length()-1){//마지막까지 다 '\0'값일때
                    correctFlag=true;
                }
            }//지속 여부 탐색 종료
            
            if(breakFlag||correctFlag){
                break;
            }
            
        }//end of while

        System.out.println(breakFlag?-1:count);  
    }
}