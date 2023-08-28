class Solution {
    public int findKthLargest(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] freq = new int[max-min+1];
        for(int num: nums) {
            freq[num-min]++;
        }
        int res = 0, count = 0;
        for(int i = max; i >= min; i--) {
            if(freq[i-min] > 0) {
                count += freq[i-min];
            }
            if(count >= k ){
                res = i;
                break;
            }
            // System.out.println(i + "-->" + freq[i-min]);
        }
        return res;
    }
}