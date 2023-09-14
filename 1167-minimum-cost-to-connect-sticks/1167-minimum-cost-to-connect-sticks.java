class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int cost = 0;
        for(int stick: sticks) {
            minHeap.offer(stick);
        }
        
        while(minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            
            int sum = first + second;
            cost += sum;
            
            minHeap.offer(sum);
        }
        return cost;
    }
}