class Solution {
    public int distanceFromOrigin(int[] point) {
        return point[1] * point[1] + point[0] * point[0];
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<List<Integer>>((List<Integer> a, List<Integer> b) -> {
            return b.get(1) - a.get(1);
        });
        int index = 0;
        for(int[] point : points) {
            if(maxHeap.size() == k) {
                if(maxHeap.peek().get(1) > distanceFromOrigin(point)) {
                    maxHeap.poll();
                    maxHeap.offer(Arrays.asList(index, distanceFromOrigin(point)));
                }
            } else {
                maxHeap.offer(Arrays.asList(index, distanceFromOrigin(point)));
            }
            index++;
        }
        int[][] res = new int[k][2];
        while(--k >= 0) {
            index = maxHeap.poll().get(0);
            res[k] = points[index];
        }
        
        return res;
    }
}