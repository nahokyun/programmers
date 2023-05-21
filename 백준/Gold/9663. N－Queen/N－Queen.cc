#include<iostream>
#include<math.h>

using namespace std;
int n;
int chess_field[16];
int ct=0;
bool check(int idx) {//

	
	for (int i = 0; i < idx; i++) {
		if (chess_field[i] == chess_field[idx] || abs(idx - i) == abs(chess_field[idx] - chess_field[i]))
			return false;
	}
	return true;
}
void nqueen(int idx) {
	if (idx == n) {
		ct++;
		return;
	}
	else {
		for (int i = 0; i < n; i++) {
			chess_field[idx] = i;
			if (check(idx)==true)
				nqueen(idx + 1);
		}

	}

}

int main() {
	cin >> n;

	nqueen(0);

	cout << ct << endl;



}