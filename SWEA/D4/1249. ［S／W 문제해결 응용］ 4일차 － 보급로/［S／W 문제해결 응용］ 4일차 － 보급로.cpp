#include<string>
#include<queue>
#include<iostream>

using namespace std;
int map[101][101];
int dp[101][101];
bool flag[101][101];
int dx[4] = { -1,1,0,0 };
int dy[4] = { 0,0,-1,1 };
int n;

void bfs(int x, int y) {

	queue<pair<int, int>> q;
	q.push({ x,y });
	flag[y][x] = true;
	dp[y][x] = map[y][x];

	while (!q.empty()) {
		int curx = q.front().first;
		int cury = q.front().second;

		q.pop();

		for (int i = 0; i < 4; i++) {
			int cmpx = curx + dx[i];
			int cmpy = cury + dy[i];

			if (cmpx >= 0 && cmpy >= 0 && cmpx < n && cmpy < n) {
				if (flag[cmpy][cmpx] == false || dp[cmpy][cmpx] > map[cmpy][cmpx] + dp[cury][curx]) {
					dp[cmpy][cmpx] = map[cmpy][cmpx] + dp[cury][curx];
					q.push({ cmpx,cmpy });
					flag[cmpy][cmpx] = true;
				}
			}

		}

	}

}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	int x;
	int sz;
	string s;
	cin>>T;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/
	for(test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				map[i][j] = 0;
				dp[i][j] = 0;
				flag[i][j] = false;
			}
		}
		for (int i = 0; i < n; i++) {
			cin >> s;
			for (int j = 0; j < n; j++) {
				map[i][j] = s[j]-'0';
			}
		}
		bfs(0, 0);

		cout <<"#"<<test_case<<" "<< dp[n - 1][n - 1] << endl;


	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}