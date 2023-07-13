#include<vector>
#include<cstring>
#include<iostream>
#include<algorithm>

using namespace std;
vector < pair<int, int>> t;//칼로리,맛
int dp[21][10001];
int n;
int limit;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int taste, cal;
		t.clear();
		memset(dp, 0, sizeof(dp));

		cin >> n >> limit;
		t.push_back({ 0,0 });//dp인덱스 계산 편하게 0값 입력
		for (int i = 0; i < n; i++) {
			cin >> taste >> cal;
			t.push_back({ cal,taste });
		}

		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <= limit; j++) {
				int cur_cal = t[i].first;
				int cur_score = t[i].second;
				if (t[i].first > j) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cur_cal] + cur_score);
				}
			}
		}
		cout << "#" << test_case << " " <<dp[n][limit] << endl;
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}