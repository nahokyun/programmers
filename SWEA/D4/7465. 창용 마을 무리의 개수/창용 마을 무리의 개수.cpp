#include<iostream>
#include<vector>
#include<cstring>
using namespace std;
int flag[101];
vector<int> arr[101];

void dfs(int x) {
	for (int i = 0; i < arr[x].size(); i++) {
		if (!flag[arr[x][i]]) {
			flag[arr[x][i]] = true;
			dfs(arr[x][i]);
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
		for (int i = 0; i < 101; i++) {
			arr[i].clear();
		}
		memset(flag, false, sizeof(flag));
		int n, m;
		cin >> n >> m;
		int first, second;
		for (int i = 1; i <= n; i++) {
			arr[i].push_back(i);
		}
		for (int i = 0; i < m; i++) {
			cin >> first >> second;
			arr[first].push_back(second);
			arr[second].push_back(first);
		}
		int ct = 0;
		for (int i = 1; i <= n; i++) {
			if (!flag[i]) {
				ct++;
				dfs(i);
			}
		}
		cout << "#" << test_case << " " << ct << endl;

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}