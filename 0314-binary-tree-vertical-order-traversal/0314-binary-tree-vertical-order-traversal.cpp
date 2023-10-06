/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> verticalOrder(TreeNode* root) {
        map<int, vector<int>> levels;
        vector<vector<int>> result;
        queue<pair<TreeNode*,int>> q;
        if(root) q.emplace(root, 0);
        while(!q.empty()) {
            auto peek = q.front();
            auto node = peek.first;
            auto level = peek.second;
            levels[level].emplace_back(node->val);
            q.pop();
            if(node -> left) {
                q.emplace(node->left, level - 1);
            }
            if(node -> right) {
                q.emplace(node->right, level + 1);
            }
        }
        for(auto level: levels) {
            result.emplace_back(level.second);
        }
        return result;
    }
};