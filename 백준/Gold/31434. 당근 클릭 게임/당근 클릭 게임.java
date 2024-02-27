import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());

		List<Action>[] actions= new ArrayList[K+1];
		for(int i=0;i<K+1;i++){
			actions[i]=new ArrayList<>();
		}
		int[] costs=new int[N+1];
		int[] increaseS=new int[N+1];
		actions[1].add(new Action(1,1));


		for(int i=1;i<=N;i++){
			st=new StringTokenizer(br.readLine());
			costs[i]=Integer.parseInt(st.nextToken());//cost
			increaseS[i]=Integer.parseInt(st.nextToken());//증가할 s
		}
		//입력 종료

		for(int i=1;i<=N;i++) {
			int curCost=costs[i];
			int curInc=increaseS[i];
			for (int j = 1; j < K; j++) {
				for (int k = 0; k < actions[j].size(); k++) {
					Action cur = actions[j].get(k);
					int cmpCarrot=0;
					int cmpInc=0;

					//s를 눌러서 당근을 받는경우
					cmpCarrot=cur.carrot+cur.increaseCarrot;
					cmpInc=cur.increaseCarrot;
					boolean flag=false;
					for(int l=0;l<actions[j+1].size();l++){
						Action tmp=actions[j+1].get(l);
						if(tmp.carrot==cmpCarrot){
							if(tmp.increaseCarrot>cmpInc){
								break;
							}
							tmp.increaseCarrot= cmpInc;
							flag=true;
							break;
						}
					}
					if(!flag) {
						actions[j + 1].add(new Action(cmpCarrot, cmpInc));
					}



					if (cur.carrot >= curCost){//당근 지불이 가능해서 지불하고 에너지를 추가함
						boolean flag2=false;
						cmpCarrot=cur.carrot-curCost;
						cmpInc=cur.increaseCarrot+curInc;
						for(int l=0;l<actions[j+1].size();l++){
							Action tmp=actions[j+1].get(l);
							if(tmp.increaseCarrot==cmpInc){
								if(tmp.carrot>cmpCarrot){
									break;
								}
								tmp.carrot= cmpCarrot;
								flag2=true;
								break;
							}
						}
						if(!flag2) {
							actions[j + 1].add(new Action(cmpCarrot, cmpInc));
						}
					}



				}
			}
		}

		int maxCarrot=0;
		for(int i=0;i<actions[K].size();i++){
			maxCarrot=Math.max(maxCarrot,actions[K].get(i).carrot);
		}

		System.out.println(maxCarrot);


	}
	static class Action{
		int carrot;
		int increaseCarrot;

		public Action(int carrot, int increaseCarrot) {
			this.carrot = carrot;
			this.increaseCarrot = increaseCarrot;
		}
	}
}
