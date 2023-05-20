

#include<iostream>
#include<cstring>
#include<string>

using namespace std;
int map[49][49];
int main(int argc, char** argv)
{
	int test_case;
	int T;
    string s;
	cin>>T;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int n;
        cin>>n;
        int sum = 0;
		memset(map, 0, sizeof(map));
		for (int i = 0; i < n; i++) {
			cin >> s;
			for (int j = 0; j < n; j++) {
				map[i][j] = s[j]-'0';
			}
		}
		int start = n / 2;
		int end = n / 2;
		for (int i = 0; i < n; i++) {
			for (int j = start; j <= end; j++) {
				sum += map[i][j];
			}
			if (i < n / 2) {
				start--;
				end++;
			}
			else {
				start++;
				end--;
			}
		}
		cout <<"#"<<test_case<<" "<< sum << endl;


	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}