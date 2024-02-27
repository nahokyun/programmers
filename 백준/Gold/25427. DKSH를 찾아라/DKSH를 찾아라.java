import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Long>[] list=new ArrayList[4];
	static List<Long>[] sums=new ArrayList[4];
	static int possibleCount=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s=br.readLine();

		for(int i=0;i<4;i++){
			list[i]=new ArrayList<>();
			sums[i]=new ArrayList<>();
		}

		for(int i=0;i<n;i++){
			switch (s.charAt(i)){
				case 'D':
					list[0].add((long)i);
					break;
				case 'K':
					list[1].add((long)i);
					sums[1].add(0L);
					break;
				case 'S':
					list[2].add((long)i);
					sums[2].add(0L);
					break;
				case 'H':
					list[3].add((long)i);
					sums[3].add(0L);
					break;
			}
		}
		for(int i=0;i<list[0].size();i++){
			sums[0].add((long)(i+1));
		}

		for(int i=1;i<4;i++){// KSH부분
			for(int j=0;j<list[i].size();j++){
				for(int k=list[i-1].size()-1;k>=0;k--){
					if(list[i-1].get(k)<list[i].get(j)){
						sums[i].set(j,sums[i].get(j)+sums[i-1].get(k));
						break;
					}
				}
				if(j>=1) {
					sums[i].set(j, sums[i].get(j - 1) + sums[i].get(j));
				}
			}
		}

		if(!sums[3].isEmpty()) {
			System.out.println(sums[3].get(sums[3].size() - 1));
		}else{
			System.out.println(0);
		}
	}

}
