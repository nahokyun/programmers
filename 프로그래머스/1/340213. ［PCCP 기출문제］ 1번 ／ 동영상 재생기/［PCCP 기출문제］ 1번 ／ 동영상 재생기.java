import java.util.*;
import java.awt.Point;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        String[] vl=video_len.split(":");
        
        Point videoLen=changeMinSec(video_len);
        Point curPos=changeMinSec(pos);
        Point opStart=changeMinSec(op_start);
        Point opEnd=changeMinSec(op_end);
        
        //변환전 오프닝체크
        curPos=openingCheck(curPos, opStart,opEnd,videoLen);

        for(String s:commands){
            curPos=calTime(curPos,s);
            curPos=openingCheck(curPos,opStart,opEnd,videoLen);
            //System.out.println("현재 시각 "+curPos.x+" "+curPos.y);
        }
        
        
        
        //원래 시간꼴로 작성
        StringBuilder sb=new StringBuilder();
        if(curPos.x<10){
            sb.append('0').append(curPos.x);
        }else{
            sb.append(curPos.x);
        }
        sb.append(':');
        if(curPos.y<10){
            sb.append('0').append(curPos.y);
        }else{
            sb.append(curPos.y);
        }
        
        
        
        answer=sb.toString();
        
        return answer;
    }
    private static Point openingCheck(Point curPos, Point opStart, Point opEnd,Point videoLen){
        boolean isOpening=false;
        if(curPos.x>=opStart.x){
            if(curPos.x==opStart.x){//같은 분이면 초로 비교
                if(curPos.y>=opStart.y){
                    if(curPos.x<opEnd.x){
                        isOpening=true;
                    }
                    if(curPos.x==opEnd.x){
                        if(curPos.y<opEnd.y){
                            isOpening=true;
                        }
                    }
                }
            }else{//같은 분은 아닐때
                if(curPos.x<opEnd.x){
                    isOpening=true;
                }
                if(curPos.x==opEnd.x){
                    if(curPos.y<opEnd.y){
                        isOpening=true;
                    }
                }
            }
        }
        
        if(isOpening){
            curPos=opEnd;
        }else{
            //오프닝 범위가 아닐경우 && 비디오 길이보다 클경우 
            if(curPos.x>videoLen.x){
                curPos=videoLen;
            }else if(curPos.x==videoLen.x){
                if(curPos.y>videoLen.y){
                    curPos=videoLen;
                }
            }
        }
        return curPos;
        
    }
    
    
    private static Point calTime(Point curPos,String s){
        int min=0;
        int sec=0;
        switch(s){
            case "next":
                min=curPos.x;
                sec=curPos.y+10;
                if(sec>=60){
                    min++;
                    sec=sec%60;
                }
                curPos=new Point(min,sec);
                break;
            case "prev":
                min=curPos.x;
                sec=curPos.y-10;
                if(sec<0){
                    min--;
                    sec=60+sec;
                }
                if(min<0){
                    curPos=new Point(0,0);
                }else
                    curPos=new Point(min,sec);
                break;
        }
        return curPos;
       
    }
    
    private static Point changeMinSec(String cur){
        int min=Integer.parseInt(cur.split(":")[0]);
        int sec=Integer.parseInt(cur.split(":")[1]);
        
        return new Point(min,sec);  
    }
}