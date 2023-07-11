#include<iostream>
#include<queue>
#include<cstring>

using namespace std;

int map[15][15];
int dp[15][15];
bool flag[15][15];
int endx, endy;
int dx[5] = {0,0,0,-1,1};
int dy[5] = {1,-1,0,0,0};
int n;

void bfs(int sty, int stx) {
	queue<pair<pair<int, int>,pair<int,int>>> q;// {시작좌표x,시작좌표y}, {현재시간, 현 위치에서 대기한 시간}
	q.push({ { stx,sty },{0,0} });

	while (!q.empty()) {
		int curx = q.front().first.first;
		int cury = q.front().first.second;
		int curtime = q.front().second.first;
		int waiting = q.front().second.second;

		q.pop();
		flag[cury][curx] = true;
		for (int i = 0; i < 5; i++) {
			int cmpx = curx + dx[i];
			int cmpy = cury + dy[i];
			if (cmpx >= 0 && cmpx < n && cmpy >= 0 && cmpy < n) {
				if (i == 2) {
					if (waiting == 3) {
						continue;
					}
					q.push({ { cmpx,cmpy }, { curtime + 1,waiting + 1 } });
				}
				else if (map[cmpy][cmpx] == 0 || (map[cmpy][cmpx] == 2 && curtime % 3 == 2)) {
					if (!flag[cmpy][cmpx] || dp[cmpy][cmpx] > curtime + 1) {
						dp[cmpy][cmpx] = curtime + 1;
						flag[cmpy][cmpx] = true;
						q.push({ {cmpx,cmpy},{curtime + 1,0} });
					}
				}
			}
		}
	}
}

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		memset(map, 0, sizeof(map));
		memset(flag, false, sizeof(flag));
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++)
				dp[i][j] = 100000;
		}
		
		cin >> n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> map[i][j];
			}
		}
		int startx, starty;
		
		cin >> starty >> startx >> endy >> endx;
		flag[starty][startx] = true;
		dp[starty][startx] = 0;
		bfs(starty, startx);
		if (dp[endy][endx] == 100000)
			dp[endy][endx] = -1;

		cout << "#" << test_case << " " << dp[endy][endx] << endl;


	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}

