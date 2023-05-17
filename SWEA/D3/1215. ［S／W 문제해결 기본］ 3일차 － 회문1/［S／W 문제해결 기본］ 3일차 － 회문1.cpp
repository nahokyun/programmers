#include<string>
#include<iostream>

using namespace std;
char map[8][8];
int counta=0;
void check(string s) {
	int sz = s.size();
	for (int i = 0; i < sz/2; i++) {
		if (s[i] != s[sz - i - 1])
			return;
	}
	counta++;
}
int main(int argc, char** argv)
{
	int test_case;
	int T;
    string s;
	//cin>>T;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        int n;
        counta=0;
        cin>>n;
		for (int i = 0; i < 8; i++) {
			cin >> s;
			for (int j = 0; j < 8; j++) {
				map[i][j] = s[j];
			}
		}
		for (int i = 0; i < 8; i++) {//가로 탐색
			
			for (int k = 0; k <= 8 - n; k++) {
                string temp = "";
				for (int j = 0; j < n; j++) {
					temp += map[i][j+k];
				}
				check(temp);
			}
		}
		for (int i = 0; i < 8; i++) {
			
			for (int k = 0; k <= 8 - n; k++) {
                string temp = "";
				for (int j = 0; j < n; j++) {
					temp += map[j+k][i];
				}
				check(temp);
			}
		}
		cout <<"#"<<test_case<<" "<< counta << endl;



	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}