import java.util.*;

class Solution {
    static int[] timePrev;
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        
        
        //최대 문제 레벨 탐색
        int right=0;
        for(int i=0;i<diffs.length;i++){
            right=Math.max(diffs[i],right);
        }
        
        int left=0;
        int mid;
        
        while(left+1<right){
            mid=(left+right)>>1;
            //System.out.println("탐색 시작 : "+mid);
            if(isValid(diffs, times, limit, mid)){//mid레벨일때 limit초 안에 풀수있는경우
                //레벨 낮추면 소요시간 증가
                //System.out.println("가능 : "+mid);
                right=mid;
            }else{
                //System.out.println("불가능 : "+mid);
                left=mid;
            }
            
        }
         
        return right;
    }
    
    private static boolean isValid(int[] diffs, int[] times, long limit, int mid){
        
        long allTime=times[0];   
        
        for(int i=1;i<diffs.length;i++){
            if(diffs[i]<=mid){
                allTime+=times[i];
            }else if(diffs[i]>mid){
                allTime+=(long)(diffs[i]-mid)*(times[i-1]+times[i])+times[i];
            }
        }
        //System.out.println("총 소요시간 : "+allTime);
        return allTime<=limit?true:false;
        
    }
    
    
}