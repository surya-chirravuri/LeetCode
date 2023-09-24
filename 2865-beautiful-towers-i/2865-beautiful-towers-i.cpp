class Solution {
public:
    long long maximumSumOfHeights(vector<int>& maxHeights) {
        long long maxSum = 0;
        for(int peakIndex = 0; peakIndex < maxHeights.size(); peakIndex++ ) {
            long long sum = 0;
            vector<int> heights(maxHeights.size());
            heights[peakIndex] = maxHeights[peakIndex];
            for(int i = peakIndex-1; i >= 0; i--) {
                heights[i] = min(maxHeights[i], heights[i+1]);
            }
            for(int i = peakIndex + 1; i < maxHeights.size() ; i++) {
                heights[i] = min(heights[i-1], maxHeights[i]);
            }
            for(auto h: heights){
                sum += h;
            }
            maxSum = max(sum, maxSum);
        }
        return maxSum;
    }
};