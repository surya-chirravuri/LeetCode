class Solution {
public:
    int fib(int N) {
        vector<int> res(N+1);
        if(N==0) return 0;
        if(N==1) return 1;
        res[0]=0,res[1]=1;
        for(int i=2;i<=N;i++)
            res[i]=res[i-1]+res[i-2];
        return N==0?0:res[N];
    }
};