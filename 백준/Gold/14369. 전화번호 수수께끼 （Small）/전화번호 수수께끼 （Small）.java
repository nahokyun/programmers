import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr=new int[10][26];
    static boolean alreadyFound=false;
    static String ans;
    static String[] numString={"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(br.readLine());

        for(int i=0;i<10;i++){
            for(int j=0;j<numString[i].length();j++){
                arr[i][numString[i].charAt(j)-'A']++;
            }
        }//1~10 숫자들 알파벳 초기화 작업


        for(int test=1;test<=t;test++){
            String cur=br.readLine();
            int[] numCount=new int[26];
            for(int i=0;i<cur.length();i++){
                numCount[cur.charAt(i)-'A']++;
            }// 주어진 문자열이 어떤 알파벳 사용하는지 체크 완료


            String tmp="";
            // alreadyFound=false;
            found(numCount,0,tmp);

            sb.append("Case #").append(test).append(": ").append(ans).append('\n');
        }//end of testcase
        System.out.print(sb.toString());
    }//end of main

    private static void found(int[] numCount, int startIdx, String tmp) {
        if(check(numCount)){//모든 알파벳 카운트가 0일때 true 리턴
            ans=tmp;
            alreadyFound=true;
            return;
        }


        for(int i=startIdx;i<10;i++){
            int[] cmp=arr[i];
            if(check2(numCount,cmp)){//해당 알파벳의 구성 알파벳들을 다 빼도 괜찮으면 true
                for(int j=0;j<26;j++){
                    numCount[j]-=cmp[j];
                }
                found(numCount,i,tmp+i);
                for(int j=0;j<26;j++){
                    numCount[j]+=cmp[j];
                }
                found(numCount,i+1,tmp);
                if(alreadyFound)
                    return;
            }
        }
    }

    private static boolean check2(int[] numCount, int[] cmp) {
        for(int i=0;i<26;i++){
            if(numCount[i]-cmp[i]<0){
                return false;
            }
        }
        return true;
    }

    private static boolean check(int[] numCount) {
        for(int i=0;i<26;i++){
            if(numCount[i]>0)
                return false;
        }
        return true;
    }
}