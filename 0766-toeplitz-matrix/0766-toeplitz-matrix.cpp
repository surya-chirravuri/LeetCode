class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        for(int i = 0; i < n; i++) {
           int r = 1, c = i + 1, val = matrix[0][i];
           while(r < m && c < n) {
               if(val != matrix[r++][c++])
                   return false;
           }
        }
        for(int i = 1; i < m; i++) {
           int r = i + 1, c = 1, val = matrix[i][0];
           while(r < m && c < n) {
               if(val != matrix[r++][c++])
                   return false;
           }
        }
        return true;
    }
};