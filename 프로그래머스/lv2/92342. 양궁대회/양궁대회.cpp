#include <string>
#include <vector>

using namespace std;

vector<int> result= { 0,0,0,0,0,0,0,0,0,0,0,0 };
vector<int> cp;
vector<int> answer;
int max_dif=0;
int idx=0;

bool cmp(vector<int> result) {
    for (int i = 10; i >= 0; i--) {
        if (result[i] > answer[i])
            return true;
        else if (result[i] < answer[i])
            return false;
    }
}

void dfs(int idx,int arrow) {
    if (arrow == 0 || idx == 11) {
        result[10] += arrow;

        int r_grade = 0;
        int a_grade = 0;
        for (int i = 0; i < 11; i++) {
            if (cp[i] < result[i]) {
                r_grade += 10 - i;
            }
            else {
                if (cp[i] != 0)
                    a_grade += 10 - i;
            }
        }
        if (r_grade - a_grade > 0) {
            if (max_dif <= r_grade - a_grade) {
                if (max_dif == r_grade - a_grade && !cmp(result))
                    return;
                max_dif = r_grade - a_grade;
                answer=result;
            }
        }


        result[10] -= arrow;
        return;
    }
    if (cp[idx] < arrow) {
        result[idx] += cp[idx] + 1;
        dfs(idx + 1,arrow-cp[idx]-1);
        result[idx] -= cp[idx] + 1;
    }
    dfs(idx + 1,arrow);

}


vector<int> solution(int n, vector<int> info) {//info=어피치가 맞춘 표
    
    for(int i=0;i<11;i++){
        cp.push_back(info[i]);
    }
    dfs(0,n);
    
    if(answer.empty())
        answer.push_back(-1);
    else
        answer.pop_back();
    return answer;
}