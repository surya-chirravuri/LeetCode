class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        auto cmp = [](vector<int> a, vector<int> b) {
            return a[0]*a[0] + a[1]*a[1] < b[0]*b[0] + b[1]*b[1];
        };
        priority_queue<vector<int>, vector<vector<int>>, decltype(cmp)> pq(cmp);
        vector<vector<int>> res(k);
        for(auto point: points) {
            pq.push(point);
            if(pq.size() > k)
                pq.pop();
        }
        while(!pq.empty()) {
            res[--k] = pq.top();
            pq.pop();
        }
        return res;
    }
};