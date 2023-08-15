#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main() {
	int n,c;
	vector<int> road;
	cin >> n>>c;
	int x;
	for (int i = 0; i < n; i++) {
		cin >> x;
		road.push_back(x);
	}
	sort(road.begin(), road.end());

	//여기서 start와 finish는 거리를 의미하기때문에 road[i]의 값이 아닌 거리 1과 road[n-1]-road[0]으로 함
	int start = 1;//최소거리
	int finish = road[n - 1]-road[0];//최대거리
	int len = 0;
	while (start <= finish) {
		int count = 1;//공유기 숫자세는 카운트
		int mid = (start + finish) / 2;//현재 간격
		int prev = road[0];
		for (int i = 1; i < n; i++) {//간격을 만족하는 집 사이 거리의 수 체크
			if (road[i] - prev >= mid) {
				count++;
				prev = road[i];
			}
		}
		if (count >= c) {//공유기를 주어진 수보다 많이 사용했음->간격을 늘려야함
			start = mid + 1;
			len = max(len, mid);//최대거리 기록
		}
		else {
			finish= mid - 1;
			
		}


	}
	cout << len << endl;
	

}