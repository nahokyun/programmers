import java.util.*;
import java.awt.Point;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        Point[] cars=new Point[10000];
        int[] bills=new int[10000];
        
        
        for(int i=0;i<records.length;i++){
            String[] partition=records[i].split(" ");
            String time=partition[0];//현재 시간
            int carNum=Integer.parseInt(partition[1]);//차번호
            String action=partition[2];//in or out
            
            int hour=Integer.parseInt(time.split(":")[0]);
            int min=Integer.parseInt(time.split(":")[1]);
            
            if(action.equals("IN")){
                if(cars[carNum]==null){
                    cars[carNum]=new Point(hour,min);
                }
            }else{
                int inHour=cars[carNum].x;
                int inMin=cars[carNum].y;
                
                bills[carNum]+=calTime(hour,min,inHour,inMin);
                //System.out.println("bills["+carNum+"]"+bills[carNum]);
                cars[carNum]=null;
            }    
        }//records 탐색종료
        
        //입차만 되어있는차들 확인 후 시간 정산
        for(int i=0;i<10000;i++){
            if(cars[i]!=null){
                bills[i]+=calTime(23,59,cars[i].x,cars[i].y);
                cars[i]=null;
            }
        }
        
        
        //시간별 요금 계산
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<10000;i++){
            if(bills[i]!=0){
                li.add(calFee(bills[i], fees));
            }
        }
        int[] answer = new int[li.size()];
        
        int idx=0;
        for(Integer cur:li){
            answer[idx++]=cur;
        }
        
        
        return answer;
    }
    private static int calFee(int time, int[] fees){
        if(time>=fees[0]){
            //System.out.println(time+" : "+(int)Math.ceil((time-fees[0])/fees[2]));
            return fees[1]+(int)Math.ceil((time-fees[0])/(double)fees[2])*fees[3];
        }else{
            return fees[1];
        }
        
    }
    private static int calTime(int hour, int min, int inHour, int inMin){
        if(inHour==hour){
            return min-inMin;
        }
        return (hour-inHour)*60+min-inMin;
    }
}