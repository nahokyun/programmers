#include <string>
#include <vector>
#include<algorithm>
#include<iostream>

using namespace std;

int c;

bool cmp(vector<int> &a,vector<int> &b){
    if(a[c-1]==b[c-1])
        return a[0]>b[0];
    else
        return a[c-1]<b[c-1];
}

int solution(vector<vector<int>> data, int col, int row_begin, int row_end) {
    int answer = 0;
    c=col;
    sort(data.begin(),data.end(),cmp);
    vector<int> ans;
    for(int i=row_begin-1;i<row_end;i++){
        int sum=0;
        //cout<<i<<endl;
        for(int j=0;j<data[i].size();j++){
            //cout<<data[i][j]<<" ";
            sum+=data[i][j]%(i+1);
        }
        //cout<<endl;
        ans.push_back(sum);
    }
    
    for(int i=0;i<ans.size();i++){
        answer=answer ^ ans[i];
        //cout<<ans[i]<<" ";
    }
    return answer;
}