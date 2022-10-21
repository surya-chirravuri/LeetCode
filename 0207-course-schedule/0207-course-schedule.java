class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : prerequisites) {
            indegree[edge[0]]++;
            List<Integer> list = graph.getOrDefault(edge[1], new ArrayList<Integer>());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }
        
        
        Queue<Integer> queue= new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }
        
        while(!queue.isEmpty()) {
            int front = queue.poll();
            numCourses--;
            
            for(int node: graph.getOrDefault(front, new ArrayList<>())) {
                if(--indegree[node] == 0)
                    queue.offer(node);
            }
        }
        
        return numCourses == 0;
    }
}