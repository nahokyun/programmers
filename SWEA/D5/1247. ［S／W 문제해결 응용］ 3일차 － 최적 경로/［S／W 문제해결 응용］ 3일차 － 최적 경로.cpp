#include<iostream>
#include<algorithm>
#include<vector>
#include<cstring>

using namespace std;

vector<pair<int, int>> coordinate;//회사, 집, 거래처의 {x,y} 좌표
bool flag[10];
int n;
int answer;
int houseX;
int houseY;

int cal_dist(int x, int y, int beforex, int beforey) {
	return abs(beforex - x) + abs(beforey - y);
}



int dfs(int beforex,int beforey, int x, int y, int cur, int dist_sum) {
	if (cur == n) {
		int result= cal_dist(x, y, houseX, houseY) + dist_sum;
		if (result < answer) {
			answer=result;
		}
	}
	else {
		for (int i = 0; i < n; i++) {
			if (flag[i] == true)
				continue;
			flag[i]=true;
			int sum = cal_dist(coordinate[i].first, coordinate[i].second, x, y);
			dfs(x, y, coordinate[i].first, coordinate[i].second, cur + 1,dist_sum+ sum);

			flag[i] = false;
		}

	}
}

void init_() {
	memset(flag, false, sizeof(flag));
	coordinate.clear();
	answer = 1000000;
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		
		cin >> n;
		int x, y;
		int companyx;
		int companyy;

		init_();

		for (int i = 0; i < n + 2; i++) {
			cin >> x >> y;
			if (i == 0) {
				companyx = x;
				companyy = y;
			}
			else if (i == 1) {
				houseX = x;
				houseY = y;
			}
			else
				coordinate.push_back({ x,y });
		}//주어지는 좌표 입력

		int minn = 100000000;
		for (int i = 0; i < n; i++) {
			int diff = abs(coordinate[i].first - companyx) + abs(coordinate[i].second - companyy);
			flag[i] = true;
			dfs(companyx, companyy, coordinate[i].first,coordinate[i].second ,1, diff);
			flag[i] = false;
		}
		


		cout << "#" << test_case << " " << answer << endl;
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
