#include<iostream>
#include<vector>
#include<queue>
#include<cstring>

using namespace std;
char map[300][300];
bool flag[300][300];
vector<pair<int, int>> v;
int dx[8] = { 0,0,-1,1,-1,-1,1,1 };
int dy[8] = { -1,1,0,0,-1,1,-1,1 };
int n;



bool check(int y, int x) {//8방향 모두 .이라면 true리턴
	for (int i = 0; i < 8; i++) {
		int cmpy = y + dy[i];
		int cmpx = x + dx[i];
		if (cmpx>=0&&cmpx<n&&cmpy<n&&cmpy>=0&&map[y + dy[i]][x + dx[i]] == '*')
			return false;
	}
	return true;
}

void bfs(int y, int x) {//주변에 지뢰가 한개도 없는 좌표를 큐에 추가하고 지뢰발견시 해당 좌표만 flag 수정
	queue<pair<int, int>> q;
	q.push({ y,x });
	flag[y][x] = true;
	while (!q.empty()) {
		int cur_y=q.front().first;
		int cur_x = q.front().second;
		q.pop();
		for (int i = 0; i < 8; i++) {
			int cmp_y = dy[i] + cur_y;
			int cmp_x = dx[i] + cur_x;
			if (cmp_x >= 0 && cmp_x < n&&cmp_y >= 0 && cmp_y < n) {
				if(check(cmp_y, cmp_x) && !flag[cmp_y][cmp_x])
					q.push({ cmp_y,cmp_x });
				if (map[cmp_y][cmp_x] == '.')
					flag[cmp_y][cmp_x] = true;
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
		int answer = 0;
		cin >> n;
		v.clear();
		memset(map, '\0', sizeof(map));
		memset(flag, false, sizeof(flag));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cin >> map[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '.'&&check(i,j)) {
					v.push_back({ i,j });
				}
			}
		}
		//v는 사방이 .인 좌표들의 집합
		for (int i = 0; i < v.size(); i++) {
			int y = v[i].first;
			int x = v[i].second;
			if (!flag[y][x]) {
				bfs(y, x);
				answer++;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '.' && !flag[i][j])
					answer++;
			}
		}

		cout <<"#"<<test_case<<" "<< answer << endl;
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}