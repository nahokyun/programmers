
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] truth;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st=new StringTokenizer(br.readLine());


		n = Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());

		st=new StringTokenizer(br.readLine());//아는사람 수, 번호
		int num=Integer.parseInt(st.nextToken());

		HashSet<Integer> s=new HashSet<>();
		List<Integer>[] li=new ArrayList[m];
		truth=new boolean[m];

		if(num!=0){
			for(int i=0;i<num;i++){
				s.add(Integer.parseInt(st.nextToken()));
			}//아는사람 번호

			int count=0;
			for(int i=0;i<m;i++){
				li[i]=new ArrayList<>();
				st=new StringTokenizer(br.readLine());
				int k=Integer.parseInt(st.nextToken());
				for(int j=0;j<k;j++){
					li[i].add(Integer.parseInt(st.nextToken()));
				}
			}//입력 종료

			while(!isValid(s,li)){

			}

			for(int i=0;i<m;i++){
				if(!truth[i])
					count++;
			}

			System.out.println(count);
		}else{
			System.out.println(m);
		}

	}

	private static boolean isValid(HashSet<Integer> s, List<Integer>[] li) {
		boolean flag=true;

		for(int i=0;i<li.length;i++){
			for(Integer cur:li[i]){
				if(s.contains(cur)){//현재 원소가 진실을 알때 해당 라인 모두 s에 집어넣음
					truth[i]=true;
					for(Integer cur2:li[i]){
						if(!s.contains(cur2)){
							flag=false;
						}
						s.add(cur2);
					}
					break;
				}
			}
		}


		return flag;
	}
}
