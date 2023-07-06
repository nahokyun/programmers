#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
vector<int> vec(10001);//자신의 부모 노드 번호를 저장하는 벡터
vector<int> sub[10001];//자신의 자식 노드 번호들을 저장하는 벡터

vector<int> root1;//첫번째로 주어진 노드의 부모 추적
vector<int> root2;//두번째로 주어진 노드의 부모 추적
int treeSz = 0;//서브 트리의 크기

void dfs1(int x) {
	root1.push_back(vec[x]);
	if(vec[x]!=1)
		dfs1(vec[x]);
}
void dfs2(int x) {
	root2.push_back(vec[x]);
	if (vec[x] != 1)
		dfs2(vec[x]);
}

void subtree(int st) {//서브 트리 크기 측정
	treeSz++;
	for (int i = 0; i < sub[st].size(); i++) {
		subtree(sub[st][i]);
	}
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int v, e, fir, sec;
		vec.clear();
		vec.resize(10001);
		for (int i = 0; i < 10001; i++) {
			sub[i].clear();
		}
		treeSz = 0;

		cin >> v >> e >> fir >> sec;
		int par;
		int chi;

		for (int i = 0; i < e; i++) {
			cin >> par >> chi;
			vec[chi]=par;
			sub[par].push_back(chi);
		}

		dfs1(fir);
		dfs2(sec);
		reverse(root1.begin(),root1.end());
		reverse(root2.begin(), root2.end());
		//노드가 달라지는 시점의 idx, 그때의 root1[idx-1]이 공통 부모노드
		int idx = 0;
		while (root1[idx] == root2[idx]) {
			idx++;
		}

		subtree(root1[idx - 1]);

		cout <<"#"<<test_case<<" "<< root1[idx-1]<<" "<<treeSz<<endl;


	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}