class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for(int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        Queue<Integer> minHeap = new PriorityQueue<Integer>((Integer a, Integer b ) -> frequency.get(a) - frequency.get(b));
        
        for(int num: frequency.keySet()) {
            minHeap.add(num);
            if(minHeap.size() > k) minHeap.poll();
        }
        
        int [] result = new int[k];
        for(int i = k-1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }
}